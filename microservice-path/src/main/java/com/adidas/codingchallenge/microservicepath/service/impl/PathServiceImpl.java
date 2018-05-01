package com.adidas.codingchallenge.microservicepath.service.impl;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.microservicepath.domain.Path;
import com.adidas.codingchallenge.microservicepath.external.client.CityClient;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.messages.MessagesBundle;
import com.adidas.codingchallenge.microservicepath.service.PathService;
import com.adidas.codingchallenge.microservicepath.service.helper.DijkstraAlgorithmHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * City path service implementation class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private Messages messages;

    @Autowired
    private CityClient cityClient;

    @Autowired
    private DijkstraAlgorithmHelper dijkstraAlgorithmHelper;

    @Override
    public Path getPathBetweenCities(final String cityOrigin, final String cityTarget) {
        List<City> cities = this.getCities();

        City cityFrom = this.findCity(cities, cityOrigin);
        City cityTo = this.findCity(cities, cityTarget);

        List<CityConnection> cityConnections = this.getCityConnections();

        return this.calculatePath(cityConnections, cityFrom, cityTo);
    }

    private Path calculatePath(final List<CityConnection> connections,
                               final City cityOrigin, final City cityTarget) {
        Path path = new Path();

        try {
            path.setPathLessNumberOfConnections(dijkstraAlgorithmHelper.getPath(connections, cityOrigin,
                    cityTarget, Boolean.TRUE));
            path.setPathLessTime(dijkstraAlgorithmHelper.getPath(connections, cityOrigin, cityTarget,
                    Boolean.FALSE));
        } catch(ApplicationException e) {
            path.setPathLessTime(e.getMessage());
            path.setPathLessNumberOfConnections(e.getMessage());
        }

        return path;
    }

    private City findCity(final List<City> cities, final String cityName) {
        Optional<City> city = cities.stream()
                .filter(c -> StringUtils.equals(c.getName(),cityName))
                .findAny();

        if ( !city.isPresent() ) {
            throw new ApplicationException(String.format(messages.get(MessagesBundle.INVALID_CITY_ERROR.toString()),
                    cityName));
        } else {
            return city.get();
        }
    }

    private List<City> getCities() {
        List<City> cities = this.cityClient.getCities();

        if (CollectionUtils.isEmpty(cities)) {
            throw new ApplicationException(messages.get(MessagesBundle.GET_CITY_NO_RESULTS.toString()));
        } else {
            return cities;
        }
    }

    private List<CityConnection> getCityConnections() {
        List<CityConnection> cityConnections = this.cityClient.getCityConnections();

        if (CollectionUtils.isEmpty(cityConnections)) {
            throw new ApplicationException(messages.get(MessagesBundle.GET_CITY_CONNECTIONS_NO_RESULTS.toString()));
        } else {
            return cityConnections;
        }
    }
}
