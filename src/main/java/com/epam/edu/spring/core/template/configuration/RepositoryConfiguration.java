package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.bpp.InjectRandomIntBeanPostProcessor;
import com.epam.edu.spring.core.template.repository.AbstractRepository;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {
    @Bean
    public AbstractRepository arrayListItemRepository() {
        return new ArrayListItemRepository();
    }

    @Bean
    public AbstractRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }
}
