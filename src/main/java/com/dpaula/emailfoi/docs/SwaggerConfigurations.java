package com.dpaula.emailfoi.docs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigurations {

    @Value("${info.app.version}")
    private String appVersion;

    @Bean
    public OpenAPI customCofiguration() {
        return new OpenAPI()
            .info(new Info().title("Email API")
                .description("Api para envio de E-mails")
                .version(appVersion)
                .license(new License()
                    .name("")
                    .url("http://unlicense.org")))
            .externalDocs(new ExternalDocumentation()
                .description("Api para envio de E-mails")
                .url("http://teste.dpaula.com.br/email-api/v1/suporte"));
    }
}