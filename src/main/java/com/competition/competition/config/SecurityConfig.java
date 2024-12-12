package com.competition.competition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration localHostConfigs = new CorsConfiguration();
        localHostConfigs.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:5173"));
        localHostConfigs.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        localHostConfigs.setAllowedHeaders(Arrays.asList("*"));
        localHostConfigs.setAllowCredentials(true);

        CorsConfiguration externalConfigs = new CorsConfiguration();
        externalConfigs.setAllowedOrigins(Arrays.asList("*"));
        localHostConfigs.setAllowedMethods(Arrays.asList("GET"));
        localHostConfigs.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", localHostConfigs);
        source.registerCorsConfiguration("/**", externalConfigs);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection if not needed
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/**").permitAll()
                        .requestMatchers("/**").access((authentication, object) -> {
                            var request = object.getRequest();
                            String origin = request.getHeader("Origin");
                            if (origin != null && (origin.contains("localhost:3000") || origin.contains("localhost:5173"))) {
                                return new AuthorizationDecision(true); // Allow all for localhost
                            }
                            return new AuthorizationDecision(false); // Default deny
                        })
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());  // Enable HTTP Basic authentication
        return http.build();
    }
}
