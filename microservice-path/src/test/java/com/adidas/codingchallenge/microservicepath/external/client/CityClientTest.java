package com.adidas.codingchallenge.microservicepath.external.client;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.microservicepath.domain.Path;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.util.TestsUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * PathServiceImpl test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CityClientTest {

    @InjectMocks
    private CityClient cityClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private Messages messages;

    private List<City> cities;
    private List<CityConnection> cityConnections;

    @Before
    public void init() {
        this.cities = TestsUtils.getCities();
        this.cityConnections = TestsUtils.getCityConnections();
    }

    @Test
    public void whenGetCitiesWithoutErrors() {
        // Arrange
        when(this.restTemplate.getForEntity(anyString(),any())).thenReturn(new ResponseEntity<>(this.cities.toArray(), HttpStatus.OK));

        // Act
        List<City> cities = this.cityClient.getCities();

        // Assert
        assertEquals(this.cities.size(), cities.size());
    }

    @Test(expected = ApplicationException.class)
    public void whenGetCitiesWithError() {
        // Arrange
        when(this.restTemplate.getForEntity(anyString(),any())).thenThrow(new ApplicationException());

        // Act & Assert
        this.cityClient.getCities();
    }

    @Test
    public void whenGetCityConnectionsWithoutErrors() {
        // Arrange
        when(this.restTemplate.getForEntity(anyString(),any())).thenReturn(new ResponseEntity<>(this.cityConnections.toArray(), HttpStatus.OK));

        // Act
        List<CityConnection> cityConnections = this.cityClient.getCityConnections();

        // Assert
        assertEquals(this.cityConnections.size(), cityConnections.size());
    }

    @Test(expected = ApplicationException.class)
    public void whenGetCityConnectionsWithError() {
        // Arrange
        when(this.restTemplate.getForEntity(anyString(),any())).thenThrow(new ApplicationException());

        // Act & Assert
        this.cityClient.getCityConnections();
    }
}
