package com.example.users.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Bione User Management API")
                        .description("Bione API for managing users in the system")
                        .version("v1.0")
                        .contact(new Contact().name("Joao Bione").email("joao.bione@example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Repository")
                        .url("https://github.com/bioneoficial/spring-user-thiago"));
    }
}
