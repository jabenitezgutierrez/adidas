package com.adidas.codingchallenge.microservicecity.service.impl;

import com.adidas.codingchallenge.microservicecity.entity.CityConnectionEntity;
import com.adidas.codingchallenge.microservicecity.entity.CityEntity;
import com.adidas.codingchallenge.microservicecity.repository.CityConnectionRepository;
import com.adidas.codingchallenge.microservicecity.repository.CityRepository;
import com.adidas.codingchallenge.microservicecity.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * City service implementation class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityConnectionRepository cityConnectionRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityEntity> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<CityConnectionEntity> getAllCityConnections() {
        return cityConnectionRepository.findAll();
    }
}
