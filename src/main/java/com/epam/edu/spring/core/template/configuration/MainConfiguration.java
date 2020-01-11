package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfiguration.class, BeanPostProcessorConfiguration.class})
public class MainConfiguration {
}
