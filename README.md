# Spring Boot Run
```shell
docker-compose up -d
```
# See Swagger Endpoint at http://localhost:8080/swagger-ui/index.html



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