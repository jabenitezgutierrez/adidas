package com.adidas.codingchallenge.microservicepath.messages;

/**
 * Enum for messages properties
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public enum MessagesBundle {
    GET_CITY_NO_RESULTS,
    GET_CITY_CONNECTIONS_NO_RESULTS,
    INVALID_CITY_ERROR,
    GET_CITY_CONNECTIONS_ERROR,
    GET_CITIES_ERROR,
    NO_PATH_BETWEEN_CITIES;

    MessagesBundle() { }

    @Override
    public String toString() {
        return "microservice.path." + name();
    }
}
