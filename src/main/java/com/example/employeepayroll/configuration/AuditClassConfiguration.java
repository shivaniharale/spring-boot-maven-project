package com.example.employeepayroll.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditClassConfiguration {

    @Bean
    public AuditorAware<String> auditorAware(){

        return () -> Optional.ofNullable("user");
    }


}
