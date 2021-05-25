package com.springJPAPractice.springJPAPractice.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.flywaydb.core.Flyway;

@Configuration
public class FlywayConfig {
    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Bean
    @Profile("test")
    public Flyway flyway() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(URL, USERNAME, PASSWORD)
                .load();

        return flyway;
    }
}
