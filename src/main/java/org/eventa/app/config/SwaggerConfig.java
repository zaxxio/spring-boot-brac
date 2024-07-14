package org.eventa.app.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        scheme = "basic",
        type = SecuritySchemeType.HTTP
)
public class SwaggerConfig {


    public static final String HTTP_BASIC = "basic";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .description("Brac IT Application" +
                                "\n ")
                        .contact(new Contact()
                                .name("Partha Sutradhar")
                                .email("partharaj.dev@gmail.com")
                                .url("https://linkedin.com/in/partha-sutradhar")
                        ).license(new License().name("MIT"))
                        .title("Brac IT")
                        .version("2"));
    }
}