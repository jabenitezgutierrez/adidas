package com.adidas.codingchallenge.microservicecity.service.impl;

import com.adidas.codingchallenge.microservicecity.entity.CityConnectionEntity;
import com.adidas.codingchallenge.microservicecity.entity.CityEntity;
import com.adidas.codingchallenge.microservicecity.repository.CityConnectionRepository;
import com.adidas.codingchallenge.microservicecity.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * CityServiceImpl test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl cityService;

    @Mock
    private CityConnectionRepository cityConnectionRepository;

    @Mock
    private CityRepository cityRepository;

    @Test
    public void whenGetAllCities() {
        // Arrange
        CityEntity cityEntity1 = new CityEntity();
        cityEntity1.setId(1);
        cityEntity1.setName("Name 1");

        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setId(2);
        cityEntity2.setName("Name 2");

        List<CityEntity> cityEntities = Arrays.asList(cityEntity1, cityEntity2);

        when(this.cityRepository.findAll()).thenReturn(cityEntities);

        // Act
        List<CityEntity> cityEntitiesResp = this.cityService.getAllCities();

        // Assert
        assertEquals(cityEntities.size(), cityEntitiesResp.size());
        assertEquals(cityEntities.get(0).getId(), cityEntities.get(0).getId());
        assertEquals(cityEntities.get(0).getName(), cityEntities.get(0).getName());
        assertEquals(cityEntities.get(1).getId(), cityEntities.get(1).getId());
        assertEquals(cityEntities.get(1).getName(), cityEntities.get(1).getName());
    }

    @Test
    public void whenGetAllCityConnections() {
        // Arrange
        CityEntity cityEntity1 = new CityEntity();
        cityEntity1.setId(1);
        cityEntity1.setName("Name 1");

        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setId(2);
        cityEntity2.setName("Name 2");

        CityConnectionEntity cityConnection1 = new CityConnectionEntity();
        cityConnection1.setId(1);
        cityConnection1.setOrigin(cityEntity1);
        cityConnection1.setTarget(cityEntity2);
        cityConnection1.setDepartureTime(LocalTime.of(10,00));
        cityConnection1.setArrivalTime(LocalTime.of(12,00));

        CityConnectionEntity cityConnection2 = new CityConnectionEntity();
        cityConnection1.setId(2);
        cityConnection2.setOrigin(cityEntity1);
        cityConnection2.setTarget(cityEntity2);
        cityConnection2.setDepartureTime(LocalTime.of(12,00));
        cityConnection2.setArrivalTime(LocalTime.of(14,00));

        List<CityConnectionEntity> cityConnectionEntities =
                Arrays.asList(cityConnection1, cityConnection2);

        when(this.cityConnectionRepository.findAll()).thenReturn(cityConnectionEntities);

        // Act
        List<CityConnectionEntity> cityConnectionsEntitiesResp = this.cityService.getAllCityConnections();

        // Assert
        assertEquals(cityConnectionEntities.size(), cityConnectionsEntitiesResp.size());
        assertEquals(cityConnectionEntities.get(0).getId(), cityConnectionsEntitiesResp.get(0).getId());
        assertEquals(cityConnectionEntities.get(0).getOrigin(), cityConnectionsEntitiesResp.get(0).getOrigin());
        assertEquals(cityConnectionEntities.get(0).getTarget(), cityConnectionsEntitiesResp.get(0).getTarget());
        assertEquals(cityConnectionEntities.get(0).getDepartureTime(), cityConnectionsEntitiesResp.get(0).getDepartureTime());
        assertEquals(cityConnectionEntities.get(0).getArrivalTime(), cityConnectionsEntitiesResp.get(0).getArrivalTime());
        assertEquals(cityConnectionEntities.get(1).getId(), cityConnectionsEntitiesResp.get(1).getId());
        assertEquals(cityConnectionEntities.get(1).getOrigin(), cityConnectionsEntitiesResp.get(1).getOrigin());
        assertEquals(cityConnectionEntities.get(1).getTarget(), cityConnectionsEntitiesResp.get(1).getTarget());
        assertEquals(cityConnectionEntities.get(1).getDepartureTime(), cityConnectionsEntitiesResp.get(1).getDepartureTime());
        assertEquals(cityConnectionEntities.get(1).getArrivalTime(), cityConnectionsEntitiesResp.get(1).getArrivalTime());
    }
}
