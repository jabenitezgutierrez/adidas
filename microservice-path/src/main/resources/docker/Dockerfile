FROM java:8-jdk
MAINTAINER jabenitezgutierrez@gmail.com
ADD microservice-path-1.0.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]