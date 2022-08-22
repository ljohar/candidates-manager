package com.example.firstCommit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Swagger configuration to generate REST API doc
 *
 * http://localhost:8081/swagger-ui/
 * JSON: http://localhost:8081/v2/api-docs
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Candidate Manager API REST",
                "Candidate manager REST API docs",
                "1.0",
                "http://www.google.com",
                new Contact("Joha", "http://www.google.com", "ljohar.1017@gmail.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}
