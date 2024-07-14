package com.example.hackweekbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public URI applicationUri() throws URISyntaxException {
        return new URI("http://localhost:3000/api");
    }
}
