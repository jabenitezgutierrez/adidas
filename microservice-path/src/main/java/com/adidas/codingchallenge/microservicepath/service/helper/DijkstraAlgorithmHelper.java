package com.adidas.codingchallenge.microservicepath.service.helper;

import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;

import java.util.List;

/**
 * Dijkstra algorithm interface
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public interface DijkstraAlgorithmHelper {

    /**
     * Gets path between cityOrigin and cityTarget
     *
     * @param connections connections between all cities
     * @param cityOrigin City origin (from)
     * @param cityTarget City target (to)
     * @param isLessNumberOfConnections <b>true</b> get path with less connections between cityOrigin and
     *                          CityTarget, <b>false</b> get path with less time between cityOrigin
     *                          and CityTarget
     * @return Path between cityOrigin and cityTarget
     */
    String getPath(List<CityConnection> connections, City cityOrigin, City cityTarget,
                   boolean isLessNumberOfConnections);
}
