package com.adidas.codingchallenge.microservicepath.controller;


import com.adidas.codingchallenge.microservicepath.domain.Path;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * PathController test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PathController.class)
public class PathControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PathController pathController;

    @Test
    public void getCityConnectionsWithoutErrors() throws Exception {
        // Assert
        String cityOrigin = "CITY 1";
        String cityTarget = "CITY 2";

        final String pathLessNumberOfConnections = "CITY 1 | CITY 2 | CITY 3";
        final String pathLessTime = "CITY 1 | CITY 2 | CITY 3 | CITY 4 | CITY 5";

        Path path = new Path();
        path.setPathLessNumberOfConnections(pathLessNumberOfConnections);
        path.setPathLessTime(pathLessTime);

        ResponseEntity<Path> responseEntity = new ResponseEntity<>(path, HttpStatus.OK);

        when(pathController.getPathBetweenCities(cityOrigin, cityTarget)).thenReturn(responseEntity);

        // Act && Arrange
        mvc.perform(get("/path/" + cityOrigin + "/" + cityTarget)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pathLessNumberOfConnections", is(path.getPathLessNumberOfConnections())))
                .andExpect(jsonPath("$.pathLessTime", is(path.getPathLessTime())));
    }
}
