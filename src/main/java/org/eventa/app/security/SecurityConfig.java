package org.eventa.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * The type Security config.
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    public static String[] PUBLIC_URLS = {
            "/v1/brac/**",
            "/v1/spring-boot-app/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/api/process/**",
            "/public/**",
            "/actuator/**",
            "/websocket"
    };


    /**
     * Security filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(configurer ->
                        configurer.requestMatchers(PUBLIC_URLS).permitAll().anyRequest().authenticated())
                .userDetailsService(userDetailsService())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    /**
     * User details service user details service.
     *
     * @return the user details service
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails build = User.builder()
                .username("username")
                .roles("USER")
                .password(passwordEncoder().encode("password"))
                .build();
        return new InMemoryUserDetailsManager(build);
    }


    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
