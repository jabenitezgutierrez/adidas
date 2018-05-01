package com.adidas.codingchallenge.microservicepath.util;

import com.adidas.codingchallenge.microservicepath.external.domain.City;
import com.adidas.codingchallenge.microservicepath.external.domain.CityConnection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TestUtils class to generate valid data to tests
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
public class TestsUtils {

    private static City huelva = createCity(1,"HUELVA");
    private static City cadiz = createCity(2,"CADIZ");
    private static City sevilla = createCity(3,"SEVILLA");
    private static City malaga = createCity(4,"MALAGA");
    private static City cordoba =createCity(5,"CORDOBA");
    private static City jaen = createCity(6,"JAEN");
    private static City granada = createCity(7,"GRANADA");
    private static City almeria = createCity(8,"ALMERIA");

    private static List<CityConnection> cityConnections = new ArrayList<>();

    public static List<City> getCities() {
        return Arrays.asList(huelva, cadiz, sevilla, malaga, cordoba, jaen, granada, almeria);
    }

    public static List<CityConnection> getCityConnections() {
        // Sevilla and Cadiz (0.75h)
        cityConnections.add(createCityConnection(5, sevilla, cadiz, LocalTime.of(13, 45), LocalTime.of(14,30)));
        cityConnections.add(createCityConnection(6, cadiz, sevilla, LocalTime.of(13, 45), LocalTime.of(14,30)));

        // Sevilla and Cordoba (1.5h)
        cityConnections.add(createCityConnection(7, sevilla, cordoba, LocalTime.of(10, 00), LocalTime.of(11,30)));
        cityConnections.add(createCityConnection(8, cordoba, sevilla, LocalTime.of(10, 00), LocalTime.of(11,30)));

        // Cadiz and Malaga (8h)
        cityConnections.add(createCityConnection(9, cadiz, malaga, LocalTime.of(14, 00), LocalTime.of(22,00)));
        cityConnections.add(createCityConnection(10, malaga, cadiz, LocalTime.of(14, 00), LocalTime.of(22,00)));

        // Malaga and Cordoba (2h)
        cityConnections.add(createCityConnection(11, malaga, cordoba, LocalTime.of(8, 00), LocalTime.of(10,00)));
        cityConnections.add(createCityConnection(12, cordoba, malaga, LocalTime.of(8, 00), LocalTime.of(10,00)));

        // Malaga and Granada (4h)
        cityConnections.add(createCityConnection(13, malaga, granada, LocalTime.of(9, 00), LocalTime.of(01,00)));
        cityConnections.add(createCityConnection(14, granada, malaga, LocalTime.of(9, 00), LocalTime.of(01,00)));

        // Cordoba and Jaen (3h)
        cityConnections.add(createCityConnection(15, cordoba, jaen, LocalTime.of(05, 00), LocalTime.of(8,00)));
        cityConnections.add(createCityConnection(16, jaen, cordoba, LocalTime.of(05, 00), LocalTime.of(8,00)));

        // Jaen and Granada (5h)
        cityConnections.add(createCityConnection(17, jaen, granada, LocalTime.of(15, 00), LocalTime.of(20,00)));
        cityConnections.add(createCityConnection(18, granada, jaen, LocalTime.of(15, 00), LocalTime.of(20,00)));

        // Jaen and Almeria (6h)
        cityConnections.add(createCityConnection(19, jaen, almeria, LocalTime.of(17, 00), LocalTime.of(23,00)));
        cityConnections.add(createCityConnection(20, almeria, jaen, LocalTime.of(17, 00), LocalTime.of(23,00)));

        // Granada and Almeria (2h)
        cityConnections.add(createCityConnection(21, granada, almeria, LocalTime.of(19, 00), LocalTime.of(21,00)));
        cityConnections.add(createCityConnection(22, almeria, granada, LocalTime.of(19, 00), LocalTime.of(21,00)));

        return cityConnections;
    }

    private static CityConnection createCityConnection(int id, City origin, City target, LocalTime departure, LocalTime arrival) {
        CityConnection cityConnection = new CityConnection();
        cityConnection.setId(id);
        cityConnection.setOrigin(origin);
        cityConnection.setTarget(target);
        cityConnection.setDepartureTime(departure);
        cityConnection.setArrivalTime(arrival);

        return cityConnection;
    }

    private static City createCity(int id, String name) {
        City city = new City();
        city.setId(id);
        city.setName(name);

        return city;
    }
}
