package com.wsalquinga.clients.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author wsalquinga on 25/10/2023
 */
@Configuration
public class OpenAPIConfig {

    @Value("${wsalquinga.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("wilmer.alquinga21@gmail.com");
        contact.setName("Wilmer Alquinga");
        contact.setUrl("");

        License mitLicense = new License().name("Apache License 2.0").url("https://choosealicense.com/licenses/apache-2.0/");

        Info info = new Info()
                .title("Demo clients Service API")
                .version("1.0.0")
                .contact(contact)
                .description("This API exposes endpoints to manage clients.").termsOfService("")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
