package com.adidas.codingchallenge.common.restclient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

/**
 * CommonRestClient test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonRestClientTest {

    @InjectMocks
    private CommonRestClient commonRestClient;

    private String protocol = "http";
    private String host = "host.domain";
    private String port = "8080";
    private String url = "/";

    @Before
    public void init() {
        ReflectionTestUtils.setField(commonRestClient, "protocol", protocol);
        ReflectionTestUtils.setField(commonRestClient, "host", host);
        ReflectionTestUtils.setField(commonRestClient, "port", port);
        ReflectionTestUtils.setField(commonRestClient, "url", url);
    }

    @Test
    public void whenComposeUrlWithoutErrors(){
        // Assert
        final String path = "cities/connections";

        // Act
        String composeUrl = this.commonRestClient.composeUrl(path);

        // Arrange
        assertEquals(composeUrl, protocol + "://" + host + ":" + port + url + path);
    }

    @Test
    public void whenComposeUrlWithParamsWithoutErrors(){
        // Assert
        final String path = "path/connections/{0}";
        final String paramValue = "value";

        // Act
        String composeUrl = this.commonRestClient.composeUrl(path,  paramValue);

        // Arrange
        assertEquals(composeUrl, protocol + "://" + host + ":" + port + url +
                path.replace("{0}", paramValue));
    }
}
