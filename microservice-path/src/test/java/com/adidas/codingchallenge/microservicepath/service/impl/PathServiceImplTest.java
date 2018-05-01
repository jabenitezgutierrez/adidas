package com.adidas.codingchallenge.microservicepath.service.impl;

import com.adidas.codingchallenge.common.exception.ApplicationException;
import com.adidas.codingchallenge.common.resourcebundle.Messages;
import com.adidas.codingchallenge.microservicepath.domain.Path;
import com.adidas.codingchallenge.microservicepath.external.client.CityClient;
import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;
import com.adidas.codingchallenge.microservicepath.service.helper.impl.DijkstraAlgorithmHelperImpl;
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
import static org.mockito.Mockito.when;

/**
 * PathServiceImpl test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PathServiceImplTest {

    @InjectMocks
    private PathServiceImpl pathService;

    @Mock
    private Messages messages;

    @Mock
    private CityClient cityClient;

    @Mock
    private DijkstraAlgorithmHelperImpl dijkstraAlgorithmHelper;

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
    public void whenGetPathBetweenCitiesWithOutErrors() {
        // Arrange
        String pathLessTime = "CADIZ | SEVILLA | CORDOBA | MALAGA | GRANADA";
        String pathLessNumberOfConnections = "CADIZ | MALAGA | GRANADA";

        City cadiz = this.cities.get(1);
        City granada = this.cities.get(6);

        when(this.cityClient.getCities()).thenReturn(this.cities);
        when(this.cityClient.getCityConnections()).thenReturn(this.cityConnections);
        when(this.dijkstraAlgorithmHelper.getPath(this.cityConnections, cadiz,
                granada, Boolean.TRUE)).thenReturn(pathLessNumberOfConnections);
        when(this.dijkstraAlgorithmHelper.getPath(this.cityConnections, cadiz,
                granada, Boolean.FALSE)).thenReturn(pathLessTime);

        // Act
        Path path = this.pathService.getPathBetweenCities("CADIZ","GRANADA");

        // Assert
        assertEquals(path.getPathLessTime(), pathLessTime );
        assertEquals(path.getPathLessNumberOfConnections(), pathLessNumberOfConnections);
    }

    @Test(expected = ApplicationException.class)
    public void whenGetPathBetweenCitiesWithoutCitiesThenError() {
        // Arrange
        when(this.cityClient.getCities()).thenReturn(new ArrayList<>());

        // Act & Assert
        this.pathService.getPathBetweenCities("CADIZ","GRANADA");
    }

    @Test(expected = ApplicationException.class)
    public void whenGetPathBetweenCitiesWithoutCityConnectionsThenError() {
        // Arrange
        when(this.cityClient.getCityConnections()).thenReturn(new ArrayList<>());

        // Act & Assert
        this.pathService.getPathBetweenCities("CADIZ","GRANADA");
    }

    @Test(expected = ApplicationException.class)
    public void whenGetPathBetweenCitiesWithInvalidCityThenError() {
        // Arrange
        when(this.cityClient.getCityConnections()).thenReturn(new ArrayList<>());

        // Act & Assert
        this.pathService.getPathBetweenCities("CADIZZZ","GRANADA");
    }

    @Test(expected = ApplicationException.class)
    public void whenGetPathBetweenCitiesDijkstraErrorThenError() {
        // Arrange
        City cadiz = this.cities.get(1);
        City granada = this.cities.get(6);

        when(this.dijkstraAlgorithmHelper.getPath(this.cityConnections, cadiz, granada, Boolean.TRUE)).thenThrow(new ApplicationException());

        // Act & Assert
        this.pathService.getPathBetweenCities("CADIZ","GRANADA");
    }
}
