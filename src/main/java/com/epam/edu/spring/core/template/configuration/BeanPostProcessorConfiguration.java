package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.bpp.InjectRandomIntBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfiguration {
    @Bean
    public BeanPostProcessor injectRandomIntBeanPostProcessor() {
        return new InjectRandomIntBeanPostProcessor();
    }
}
