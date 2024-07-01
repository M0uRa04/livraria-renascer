package br.com.livraria_renascer.renascer.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(
                        new Info()
                                .title("Livraria Renascer API")
                                .description("API REST da aplicação feita para a livraria renascer.")
                                .contact(new Contact()
                                        .name("Robson Moura - Desenvolvedor Back-End")
                                        .email("robsonmoura970@hotmail.com"))
                );
    }


}
