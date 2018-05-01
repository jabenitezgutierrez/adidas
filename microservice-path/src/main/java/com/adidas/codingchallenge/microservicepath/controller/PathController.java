package com.adidas.codingchallenge.microservicepath.controller;

import com.adidas.codingchallenge.microservicepath.domain.Path;
import com.adidas.codingchallenge.microservicepath.service.PathService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class expose REST services to calculate paths between cities
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RestController
@RequestMapping("/path")
public class PathController {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private PathService pathService;

    /**
     * Gets all city connections from DB
     *
     * @return List with all cities
     */

    @RequestMapping(value = "/{cityOrigin}/{cityTarget}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Path> getPathBetweenCities(@PathVariable("cityOrigin") String cityOrigin,
                                                     @PathVariable("cityTarget") String cityTarget) {
        Path path = pathService.getPathBetweenCities(cityOrigin, cityTarget);

        return new ResponseEntity<>(path, HttpStatus.OK);
    }
}
