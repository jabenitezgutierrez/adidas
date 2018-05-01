package com.adidas.codingchallenge.microservicecity.service;

import com.adidas.codingchallenge.microservicecity.entity.CityConnectionEntity;
import com.adidas.codingchallenge.microservicecity.entity.CityEntity;

import java.util.List;

/**
 * City service interface
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public interface CityService {

    /**
     * Gets all cities from in DB
     *
     * @return List with all cities from DB
     */
    List<CityEntity> getAllCities();

    /**
     * Gets all city connections from DB
     *
     * @return List with all city connections from DB
     */
    List<CityConnectionEntity> getAllCityConnections();
}
