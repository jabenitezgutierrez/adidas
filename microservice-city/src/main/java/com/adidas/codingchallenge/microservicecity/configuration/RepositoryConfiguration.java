package com.adidas.codingchallenge.microservicecity.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Repository configuration
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Configuration
@EntityScan(basePackages = "com.adidas.codingchallenge.microservicecity.entity")
@EnableJpaRepositories(basePackages = "com.adidas.codingchallenge.microservicecity.repository")
public class RepositoryConfiguration { }
