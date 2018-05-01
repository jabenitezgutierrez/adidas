package com.adidas.codingchallenge.microservicecity.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Configuration
@ComponentScan(basePackages = "com.adidas.codingchallenge.microservicecity.controller")
@EnableSwagger2
@EnableWebMvc
public class AppConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        List<String> mappingFiles = Arrays.asList(
                "dozer-configuration.xml",
                "dozerJdk8Converters.xml"
        );

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.adidas.codingchallenge.microservicecity.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfo("City Service Api Documentation",
                        "Documentation automatically generated", "1.0.0",
                        null, new Contact("Juan Antonio Benitez", "", ""),
                        null, null, new ArrayList<>()));
    }
}
