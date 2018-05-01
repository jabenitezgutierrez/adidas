# Adidas coding challenge ![CI status](https://img.shields.io/badge/build-passing-brightgreen.svg)

Adidas coding challenge is a java library to calculate the sortest way(in time and in connections) to travel from one city to another, independent of the departure time. 

## Frameworks/Libraries used
* Spring 5.0.5.RELEASE - for bean injection
* Spring boot v2.0.1.RELEASE - for expose REST services
* Spring cloud v2.0.0.RC1 - for Consul and Zuul
* H2 database v1.4.197 - for persist data
* JPA v2.1 + Hibernate v5.2.16.FINAL
* Apache Commons Lang v2.2 - for use several Util classes, for instance StringUtils.
* Jackson v2.9.2 - for convert return data to JSON
* Dozer v1.0.2 - copy object data to another
* Dozer JDK8 support v1.0.2 - dozer support for JDK8
* Swagger v2.8.0 - api documentation

## Installation

### Requirements
* Docker Toolbox running
* Java 8
* Maven 3.5
* Internet connection

### Installation

```$ mvn clean package```

After packaging is completed, enter in Docker Quickstart Terminal and run the following statement (it's may takes a few minutes):

```$ docker-compose up -d```

if you want to start more serves, you should use:

```$ docker-compose up -d --scale microservice-path=<num_of_instances> --scale microservice-city=<num_of_instances>```

Where:

* <num_of_instances>: is the num of instances that you want start up.

Examples:

```
$ docker-compose up -d --scale microservice-path=2 --scale microservice-city=3
$ docker-compose up -d --scale microservice-path=3 --scale microservice-city=4
```

## Usage

Open a web browser an enter the following URL:

```
http://{DOCKER_IP}:8080/path/{CITI_ORIGIN}/{CITY_DESTINY}
```

where:
* {DOCKER_IP}: Is the IP fo access to Docker
* {CITY_ORIGIN}: From city
* {CITY_DESTINY}: To city

Examples:

```
http://192.168.99.100:8080/path/CADIZ/ALMERIA
http://192.168.99.100:8080/path/SEVILLA/GRANADA
```

## API Documentation

You can found it in the following URL:

```
http://{DOCKER_IP}:8080/swagger-ui.html
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)