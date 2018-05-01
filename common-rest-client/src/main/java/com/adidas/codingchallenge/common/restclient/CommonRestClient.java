package com.adidas.codingchallenge.common.restclient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Common RestFull client
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public class CommonRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${microservice.city.protocol:null}")
    private String protocol;

    @Value("${microservice.city.host:null}")
    private String host;

    @Value("${microservice.city.port:null}")
    private String port;

    @Value("${microservice.city.url:null}")
    private String url;

    /**
     * Gets RestTemplate instance
     *
     * @return The RestTemplate
     */
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * Compose URL to send the request
     *
     * @param path Path to resource
     * @param urlParam Params to send to resource
     * @return URL
     */
    protected String composeUrl(final String path, final String... urlParam) {
        return UriComponentsBuilder.newInstance()
                .scheme(this.protocol)
                .host(this.host)
                .port(this.port)
                .path(this.url + processPath(path, urlParam))
                .build().toUriString();
    }

    private String processPath(final String path, final String... urlParam) {
        if (urlParam != null && urlParam.length > 0) {
            String processedPath = path;

            int argNum = 0;
            for ( String param : urlParam ) {
                processedPath = StringUtils.replace(processedPath, "{" + argNum + "}", param);
            }

            return processedPath;
        } else {
            return path;
        }
    }
}
