package com.example.employee_management_application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    // bean creation for object : ModelMapper :
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
