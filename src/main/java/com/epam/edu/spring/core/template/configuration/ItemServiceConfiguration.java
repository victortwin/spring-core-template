package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ItemServiceConfiguration {

    @Bean
    public ItemService simpleItemService() {
        return new SimpleItemService();
    }

}
