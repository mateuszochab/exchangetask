package com.mateuszochab.exchangetask.infrastructure.common.exception.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.MathContext;
import java.math.RoundingMode;

@Configuration
public class MathConfiguration {

    @Bean
    public MathContext mathContext() {
        return new MathContext(10, RoundingMode.HALF_UP);
    }
}
