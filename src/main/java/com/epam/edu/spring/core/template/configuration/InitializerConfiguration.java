package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.initializer.TestDataInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class InitializerConfiguration {

    @Bean
    public TestDataInitializer testDataInitializer() {
        return new TestDataInitializer();
    }

    @Bean
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }
}
