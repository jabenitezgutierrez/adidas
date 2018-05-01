package com.adidas.codingchallenge.microservicecity.controller;

import com.adidas.codingchallenge.microservicecity.domain.City;
import com.adidas.codingchallenge.microservicecity.domain.CityConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CityController test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityController cityController;

    @Test
    public void getCitiesWithoutErrors() throws Exception {
        // Assert
        City city1 = new City();
        city1.setId(1);
        city1.setName("name 1");

        City city2 = new City();
        city2.setId(2);
        city2.setName("name 2");

        List<City> cities = Arrays.asList(city1, city2);

        ResponseEntity<List<City>> responseEntity = new ResponseEntity<>(cities, HttpStatus.OK);

        when(cityController.getCities()).thenReturn(responseEntity);

        // Act && Arrange
        mvc.perform(get("/cities")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(city1.getId())))
                .andExpect(jsonPath("$[0].name", is(city1.getName())))
                .andExpect(jsonPath("$[1].id", is(city2.getId())))
                .andExpect(jsonPath("$[1].name", is(city2.getName())));
    }

    @Test
    public void getCityConnectionsWithoutErrors() throws Exception {
        // Assert
        City city1 = new City();
        city1.setId(1);
        city1.setName("name 1");

        City city2 = new City();
        city2.setId(2);
        city2.setName("name 2");

        CityConnection cityConnection = new CityConnection();
        cityConnection.setArrivalTime(LocalTime.of(10,00));
        cityConnection.setDepartureTime(LocalTime.of(12,00));
        cityConnection.setId(1);
        cityConnection.setOrigin(city1);
        cityConnection.setTarget(city2);

        List<CityConnection> cityConnections = Arrays.asList(cityConnection);

        ResponseEntity<List<CityConnection>> responseEntity = new ResponseEntity<>(cityConnections, HttpStatus.OK);

        when(cityController.getCityConnections()).thenReturn(responseEntity);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Act & Arrange
        mvc.perform(get("/cities/connections")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(cityConnection.getId())))
                .andExpect(jsonPath("$[0].origin.id", is(cityConnection.getOrigin().getId())))
                .andExpect(jsonPath("$[0].origin.name", is(cityConnection.getOrigin().getName())))
                .andExpect(jsonPath("$[0].target.id", is(cityConnection.getTarget().getId())))
                .andExpect(jsonPath("$[0].target.name", is(cityConnection.getTarget().getName())))
                .andExpect(jsonPath("$[0].departureTime", is(cityConnection.getDepartureTime().format(dtf))))
                .andExpect(jsonPath("$[0].arrivalTime", is(cityConnection.getArrivalTime().format(dtf))));
    }
}
