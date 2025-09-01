package com.example.novalearn.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {

    private final CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private UserDetailsService userDetailsService;

    SecurityConfig(CustomerUserDetailsService customerUserDetailsService) {
        this.customerUserDetailsService = customerUserDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.httpBasic(Customizer.withDefaults());
    //     http.csrf(c -> c.disable())
    //     .cors(c -> {
    //         CorsConfigurationSource corsConfigurationSource = request -> {
    //             CorsConfiguration conf = new CorsConfiguration();
    //             conf.setAllowedOrigins(List.of("http://localhost:5173", "http://172.17.0.3:5173"));
    //             conf.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    //             conf.setAllowedHeaders(List.of("*"));
    //             conf.setAllowCredentials(true);
    //             return conf;
    //         };
    //         c.configurationSource(corsConfigurationSource);
    //     });

    //     http.authorizeHttpRequests(c -> {
    //         c.requestMatchers("/api/auth/**").permitAll();
    //         c.anyRequest().authenticated();
    //     });
    //     return http.build();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration conf = new CorsConfiguration();
        conf.setAllowedOrigins(List.of("http://localhost:5173"));
        conf.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        conf.setAllowedHeaders(List.of("*"));
        conf.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
