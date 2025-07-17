package com.example.back_end.Service.Sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SercurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity in API, consider enabling for web apps
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/products/**",
                                "/brands/**",
                                "/categories/**",
                                "/addresses/**",
                                "/cart/**",
                                "/cart-items/**",
                                "/users/**",
                                "/orders/**",
                                "/order-items/**",
                                "/payment/**",
                                "/auth/**" // Assuming you have an authentication endpoint
                        ).permitAll() // Allow all requests to /products
                        .anyRequest().authenticated() // Require authentication for any other requests
                );
        return http.build();
    }
}