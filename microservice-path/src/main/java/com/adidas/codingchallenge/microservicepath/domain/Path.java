package com.adidas.codingchallenge.microservicepath.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Class to represent a path between two cities
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Path implements Serializable {

    static final long serialVersionUID = 1L;

    private String pathLessNumberOfConnections;
    private String pathLessTime;

    /**
     * Gets path based on less number of connections
     *
     * @return The path based on less number of connections
     */
    public String getPathLessNumberOfConnections() {
        return pathLessNumberOfConnections;
    }

    /**
     * Sets path based on less number of connections
     *
     * @param pathLessNumberOfConnections The path based on less number of connections
     */
    public void setPathLessNumberOfConnections(String pathLessNumberOfConnections) {
        this.pathLessNumberOfConnections = pathLessNumberOfConnections;
    }

    /**
     * Gets path based on less time
     *
     * @return The path based on less time
     */
    public String getPathLessTime() {
        return pathLessTime;
    }

    /**
     * Sets path based on less time
     *
     * @param pathLessTime The path based on les time
     */
    public void setPathLessTime(String pathLessTime) {
        this.pathLessTime = pathLessTime;
    }
}
