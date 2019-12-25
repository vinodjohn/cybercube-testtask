package com.example.producer.config;

import com.example.producer.common.ProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Spring configuration for properties
 *
 * @author Vinod John
 */
@Configuration
@PropertySource(value = {"classpath:producer-app.properties"}, ignoreResourceNotFound = true)
public class PropertiesConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setTrimValues(true);
        return configurer;
    }

    @Bean
    public ProducerConfiguration portalConfiguration() {
        return new ProducerConfiguration();
    }
}
