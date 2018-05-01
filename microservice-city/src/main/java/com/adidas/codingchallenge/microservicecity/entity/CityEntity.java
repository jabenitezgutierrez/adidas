package com.adidas.codingchallenge.microservicecity.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * City entity class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Entity
@Table(name = "CITY")
public class CityEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID", nullable = false)
    private Integer id;

    @Column(name = "CITY_NAME", length = 100, nullable = false)
    private String name;

    /**
     * Gets city id
     *
     * @return the city id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets city id
     *
     * @param id the city id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets city name
     *
     * @return the city name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets city name
     *
     * @param name the city name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CityEntity)) {
            return false;
        }

        CityEntity other = (CityEntity) obj;
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
