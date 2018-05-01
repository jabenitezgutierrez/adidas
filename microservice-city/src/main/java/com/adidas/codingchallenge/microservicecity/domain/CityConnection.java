package com.adidas.codingchallenge.microservicecity.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Class to represent a city connection
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityConnection implements Serializable {

    static final long serialVersionUID = 1L;

    private Integer id;
    private City origin;
    private City target;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    /**
     * Gets id city connection
     *
     * @return The id city connection
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id city connection
     *
     * @param id The id city connection
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets origin city
     *
     * @return The origin city
     */
    public City getOrigin() {
        return origin;
    }

    /**
     * Sets origin city
     *
     * @param origin The origin city
     */
    public void setOrigin(City origin) {
        this.origin = origin;
    }

    /**
     * Gets target city
     *
     * @return The target city
     */
    public City getTarget() {
        return target;
    }

    /**
     * Sets target city
     *
     * @param target The target city
     */
    public void setTarget(City target) {
        this.target = target;
    }

    /**
     * Gets departure time
     *
     * @return The departure time
     */
    public LocalTime getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets departure time
     *
     * @param departureTime The departure time
     */
    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets arrival time
     *
     * @return The arrival time
     */
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets arrival time
     *
     * @param arrivalTime The arrival time
     */
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CityConnection)) {
            return false;
        }

        CityConnection other = (CityConnection) obj;
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
