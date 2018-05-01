package com.adidas.codingchallenge.microservicecity.controller;

import com.adidas.codingchallenge.microservicecity.domain.City;
import com.adidas.codingchallenge.microservicecity.domain.CityConnection;
import com.adidas.codingchallenge.microservicecity.service.CityService;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class expose RESTS services to handle cities
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    /**
     * Gets all cities from DB
     *
     * @return List with all cities
     */
    @RequestMapping(value = "/cities", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = dozerBeanMapper.map(cityService
                .getAllCities(), List.class);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    /**
     * Gets all city connections from DB
     *
     * @return List with all city connections
     */
    @RequestMapping(value = "/cities/connections", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CityConnection>> getCityConnections() {
        List<CityConnection> cityConnections = dozerBeanMapper.map(cityService
                .getAllCityConnections(), List.class);

        return new ResponseEntity<>(cityConnections, HttpStatus.OK);
    }
}
