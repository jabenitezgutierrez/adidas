package com.adidas.codingchallenge.microservicepath.external.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Class to represent a city
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City implements Serializable {

    static final long serialVersionUID = 1L;

    private Integer id;
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
        if (!(obj instanceof City)) {
            return false;
        }

        City other = (City) obj;
        return new EqualsBuilder()
                .append(this.id, other.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
