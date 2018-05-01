package com.adidas.codingchallenge.microservicecity.entity;

import com.adidas.codingchallenge.microservicecity.entity.converter.LocalTimeAttributeConverter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Convert;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * City connection class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Entity
@Table(name = "CITY_CONNECTION")
public class CityConnectionEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CITY_CONNECTION_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID_ORIGIN")
    private CityEntity origin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID_TARGET")
    private CityEntity target;

    @Column(name="DEPARTURE_TIME", nullable = false)
    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime departureTime;

    @Column(name="ARRIVAL_TIME", nullable = false)
    @Convert(converter = LocalTimeAttributeConverter.class)
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
    public CityEntity getOrigin() {
        return origin;
    }

    /**
     * Sets origin city
     *
     * @param origin The city origin
     */
    public void setOrigin(CityEntity origin) {
        this.origin = origin;
    }

    /**
     * Gets target city
     *
     * @return The target city
     */
    public CityEntity getTarget() {
        return target;
    }

    /**
     * Sets target city
     *
     * @param target The target city
     */
    public void setTarget(CityEntity target) {
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
        if (!(obj instanceof CityConnectionEntity)) {
            return false;
        }

        CityConnectionEntity other = (CityConnectionEntity) obj;
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
