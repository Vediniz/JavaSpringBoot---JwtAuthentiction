package com.github.vediniz.jwtauth.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFlywayInitializer {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public CommandLineRunner flywayCustomInitializer() {
        return args -> {
            Flyway flyway = Flyway.configure()
                    .dataSource(dataSourceUrl, dataSourceUsername, dataSourcePassword)
                    .baselineOnMigrate(true)
                    .load();
            flyway.migrate();
        };
    }
}
