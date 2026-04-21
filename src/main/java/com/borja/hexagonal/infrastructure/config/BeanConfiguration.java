package com.borja.hexagonal.infrastructure.config;


import com.borja.hexagonal.application.services.CenterService;
import com.borja.hexagonal.domain.ports.out.CenterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CenterService centerService (CenterRepository centerRepository) {
        return new CenterService(centerRepository);
    }
}
