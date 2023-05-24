package com.project.project_web_service_bank_system.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.*;

import static com.fasterxml.jackson.databind.cfg.ConstructorDetector.USE_PROPERTIES_BASED;

/*
Чтобы нормально выводился Json
 */

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .failOnUnknownProperties(false)
                .postConfigurer(mapper ->
                        mapper.setConstructorDetector(USE_PROPERTIES_BASED)
                );
    }
}
