package com.adidas.codingchallenge.microservicepath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicePathApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePathApplication.class, args);
	}
}
