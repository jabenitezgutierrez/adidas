package com.adidas.codingchallenge.microservicepath.external.client;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.common.restclient.CommonRestClient;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.messages.MessagesBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Microservice city client
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Component
public class CityClient extends CommonRestClient {

    @Autowired
    private Messages messages;

    private static final String CITY_PATH = "cities/";
    private static final String CITY_CONNECTIONS_PATH = CITY_PATH + "connections";

    /**
     * Gets all cities from microservice-city
     *
     * @return The city list
     */
    public List<City> getCities() {
        try {
            return Arrays.asList(getRestTemplate().getForEntity(composeUrl(CITY_PATH),
                            City[].class).getBody());
        } catch (Exception e) {
            throw new ApplicationException(messages.get(MessagesBundle
                    .GET_CITIES_ERROR.toString()));
        }
    }

    /**
     * Gets all city connections from microservice-city
     *
     * @return The city connections list
     */
    public List<CityConnection> getCityConnections() {
        try {
            return Arrays.asList(getRestTemplate()
                    .getForEntity(composeUrl(CITY_CONNECTIONS_PATH),
                            CityConnection[].class).getBody());
        } catch (Exception e) {
            throw new ApplicationException(messages.get(MessagesBundle
                    .GET_CITY_CONNECTIONS_ERROR.toString()));
        }
    }
}
