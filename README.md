# Spring Boot Run
```shell
docker-compose up -d
```
# See Swagger Endpoint at http://localhost:8080/swagger-ui/index.html
Compose
```yaml
services:
  brac-it-application:
    build:
      context: .
      dockerfile: src/main/docker/Dockerfile
    ports:
      - "8080:8080"
    environment:
      APP_NAME: "BRAC IT APP"
    volumes:
      - ./logs:/app/target/logs
    networks:
      - cloudNetwork


networks:
  cloudNetwork:
    driver: bridge
```

```java
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
```

# Security Test
```java
package org.eventa.app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Greetings controller with security test.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsControllerWithSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Greetings controller saying hello.
     *
     * @throws Exception the exception
     */
    @Test
    @WithMockUser(username = "username", password = "password")
    public void greetingsControllerSayingHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/greetings")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
```