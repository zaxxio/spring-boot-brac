package org.eventa.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.eventa.app.config.SwaggerConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Greetings controller.
 */
@RestController
@RequestMapping("/v1/api")
@SecurityRequirement(name = SwaggerConfig.HTTP_BASIC)
public class GreetingsController {


    /**
     * Say hello response entity.
     *
     * @return the response entity
     */
    @GetMapping("/greetings")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Hello from Partha");
    }


}
