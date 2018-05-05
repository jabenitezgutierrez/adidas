package com.adidas.codingchallenge.microservicepath.service.helper.impl;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.messages.MessagesBundle;
import com.adidas.codingchallenge.microservicepath.service.helper.DijkstraAlgorithmHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This helper class implements the Dijkstra algorithm
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Component
public class DijkstraAlgorithmHelperImpl implements DijkstraAlgorithmHelper {

    @Autowired
    private Messages messages;

    private List<CityConnection> cityConnections;
    private Set<City> settledCities;
    private Set<City> unSettledCities;
    private Map<City, City> predecessors;
    private Map<City, Long> distance;

    @Override
    public String getPath(final List<CityConnection> connections, final City cityOrigin,
                          final City cityTarget, final boolean isLessNumberOfConnections) {
        this.cityConnections = connections;

        execute(cityOrigin, isLessNumberOfConnections);
        ArrayList<City> path = getPath(cityTarget);

        if (CollectionUtils.isEmpty(path)) {
            throw new ApplicationException(String.format(this.messages.get(MessagesBundle.NO_PATH_BETWEEN_CITIES.toString()),
                    cityOrigin.getName(), cityTarget.getName()));
        } else {
            return path.stream().map(c->c.getName()).collect(Collectors.joining(" | "));
        }
    }

    private void execute(City from, boolean isLessNumberOfConnections) {
        this.settledCities = new HashSet<>();
        this.unSettledCities = new HashSet<>();
        this.distance = new HashMap<>();
        this.predecessors = new HashMap<>();
        this.distance.put(from, 0L);
        this.unSettledCities.add(from);

        while (this.unSettledCities.size() > 0) {
            City node = getMinimum(this.unSettledCities);
            this.settledCities.add(node);
            this.unSettledCities.remove(node);
            findMinimalDistances(node, isLessNumberOfConnections);
        }
    }

    private void findMinimalDistances(City node, boolean isLessNumberOfConnections) {
        List<City> adjacentCities = getNeighbors(node);

        adjacentCities.stream()
            .filter(cityTarget -> getShortestDistance(cityTarget) >
                    getShortestDistance(node) + getDistance(node,cityTarget, isLessNumberOfConnections))
            .forEach(cityTarget -> {
                this.distance.put(cityTarget, getShortestDistance(node)
                        + getDistance(node, cityTarget, isLessNumberOfConnections));
                this.predecessors.put(cityTarget, node);
                this.unSettledCities.add(cityTarget);
            });
    }

    private long getDistance(City node, City cityTarget, boolean isLessNumberOfConnections) {
        Optional<CityConnection> cityConnection = cityConnections.stream()
                .filter(cityConn -> cityConn.getOrigin().equals(node)
                        && cityConn.getTarget().equals(cityTarget))
                .findFirst();

        if (cityConnection.isPresent()) {
            return cityConnection.get().getTimeLength(isLessNumberOfConnections);
        } else {
            return Long.MAX_VALUE;
        }
    }

    private List<City> getNeighbors(City node) {
        List<City> neighbors = new ArrayList<>();

        this.cityConnections.stream()
            .filter(cityConnection -> cityConnection.getOrigin().equals(node)
                    && !isSettled(cityConnection.getTarget()))
            .forEach(c -> neighbors.add(c.getTarget()));

        return neighbors;
    }

    private City getMinimum(Set<City> cities) {
        City minimum = null;

        for (City city : cities) {
            if (minimum == null) {
                minimum = city;
            } else if (getShortestDistance(city) < getShortestDistance(minimum)) {
                    minimum = city;
            }
        }

        return minimum;
    }

    private boolean isSettled(City city) {
        return settledCities.contains(city);
    }

    private long getShortestDistance(City destination) {
        Long d = this.distance.get(destination);
        if (d == null) {
            return Long.MAX_VALUE;
        } else {
            return d;
        }
    }

    private ArrayList<City> getPath(City target) {
        ArrayList<City> path = new ArrayList<>();
        City step = target;

        // check if a path exists
        if (this.predecessors.get(step) == null) {
            return null;
        }

        path.add(step);

        while (this.predecessors.get(step) != null) {
            step = this.predecessors.get(step);
            path.add(step);
        }

        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}
