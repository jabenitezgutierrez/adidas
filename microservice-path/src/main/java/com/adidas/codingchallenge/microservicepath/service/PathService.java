package com.adidas.codingchallenge.microservicepath.service;

import com.adidas.codingchallenge.microservicepath.domain.Path;

/**
 * Path service interface
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public interface PathService {

    /**
     * Gets path with less number of connections and less time between
     * city origin and city target
     *
     * @param cityOrigin City origin
     * @param cityTarget City target
     * @return Path with less number of connections and less time between
     *      city origin and city target
     */
    Path getPathBetweenCities(String cityOrigin, String cityTarget);
}
