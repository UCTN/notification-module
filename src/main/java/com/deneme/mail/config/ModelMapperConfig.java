package com.deneme.mail.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelmapper() {

        ModelMapper modelmapper = new ModelMapper();

        modelmapper
                .getConfiguration()
                .setFieldMatchingEnabled(true)
                .setPropertyCondition(Conditions.isNotNull());
        return  modelmapper;
    }
}
