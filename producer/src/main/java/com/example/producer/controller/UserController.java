package com.example.producer.controller;

import com.example.producer.exception.BadRequestException;
import com.example.producer.model.User;
import com.example.producer.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for REST API: User operations
 *
 * @author Vinod John
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static final ObjectMapper JSON_MAPPER = Jackson2ObjectMapperBuilder.json()
            .modules(new JavaTimeModule())
            .featuresToDisable(SerializationFeature.INDENT_OUTPUT)
            .build();

    private static final String TOPIC = "users";

    @Value("${application.name}")
    private String applicationName;
    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user == null) {
            log.error("Empty request received without errors");
            throw new BadRequestException("invalid-request", "Invalid content!");
        } else {
            user.setApplicationName(applicationName);
            try {
                String userMessage = JSON_MAPPER.writeValueAsString(user);
                messageService.sendMessage(TOPIC, userMessage);
            } catch (JsonProcessingException e) {
                String errorMsg = "Failed to parse User JSON!";
                log.error(errorMsg, e);
                throw new BadRequestException("invalid-request", errorMsg, e);
            }
        }
        return ResponseEntity.ok().build();
    }
}
