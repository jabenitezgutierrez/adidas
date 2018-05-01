package com.adidas.codingchallenge.microservicepath.service.helper.impl;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.util.TestsUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * DijkstraAlgorithmHelperImpl test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DijkstraAlgorithmHelperImplTest {

    @InjectMocks
    private DijkstraAlgorithmHelperImpl dijkstraAlgorithmHelper;

    @Mock
    private Messages messages;

    private List<City> cities = new ArrayList<>();
    private List<CityConnection> cityConnections = new ArrayList<>();

    @Before
    public void init() {
        // Cities
        this.cities = TestsUtils.getCities();

        // CityConnections
        this.cityConnections = TestsUtils.getCityConnections();
    }

    @Test
    public void whenGetPathWithLessTimeThenNoErrors() {
        // Arrange
        String path = "CADIZ | SEVILLA | CORDOBA | MALAGA | GRANADA";

        City cadiz = this.cities.get(1);
        City granada = this.cities.get(6);

        // Act
        String pathRes = this.dijkstraAlgorithmHelper.getPath(this.cityConnections, cadiz, granada, Boolean.FALSE);

        // Assert
        assertEquals(path, pathRes);
    }

    @Test
    public void whenGetPathWithLessNumberOfConnectionsThenNoErrors() {
        // Arrange
        String path = "CADIZ | MALAGA | GRANADA";

        City cadiz = this.cities.get(1);
        City granada = this.cities.get(6);

        // Act
        String pathRes = this.dijkstraAlgorithmHelper.getPath(this.cityConnections, cadiz, granada, Boolean.TRUE);

        // Assert
        assertEquals(path, pathRes);
    }

    @Test(expected = ApplicationException.class)
    public void whenGetPathWithWithNoPathBetweenCitiesThenError() {
        // Arrange
        City huelva = this.cities.get(0);  // Huelva is isolated
        City granada = this.cities.get(6);

        when(this.messages.get(anyString())).thenReturn("String %s %s");

        // Act & Assert
        this.dijkstraAlgorithmHelper.getPath(this.cityConnections, huelva, granada, Boolean.TRUE);
    }
}
