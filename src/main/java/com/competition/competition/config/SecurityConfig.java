package com.competition.competition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection if not needed
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").permitAll()  // Allow access to /api/card/add
                        .anyRequest().authenticated()  // Require authentication for any other requests
                )
                .httpBasic(Customizer.withDefaults());  // Enable HTTP Basic authentication

        return http.build();
    }
}
