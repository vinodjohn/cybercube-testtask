package com.example.producer.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * Provides a single gateway to access application configuration parameters
 *
 * @author Vinod John
 */
@Slf4j
@Getter
public class ProducerConfiguration {
    @Value("${application.name}")
    private String applicationName;
}
