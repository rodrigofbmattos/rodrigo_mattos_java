package br.edu.infnet.rodrigo_mattos_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API: Aluguel de Veiculos")
                .version("1.0")
                .description("API para aluguel de veiculos.")
                .contact(new Contact()
                    .name("Rodrigo Mattos")
                    .email("rodrigo.mattos@al.infnet.edu")));
    }
}
