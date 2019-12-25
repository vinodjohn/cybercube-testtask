package com.example.consumer.service;

import com.example.consumer.exception.BadRequestException;
import com.example.consumer.model.User;
import com.example.consumer.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service implementation of user service
 *
 * @author Vinod John
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private static final ObjectMapper JSON_MAPPER = Jackson2ObjectMapperBuilder.json()
            .modules(new JavaTimeModule())
            .featuresToDisable(SerializationFeature.INDENT_OUTPUT)
            .build();

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "users", groupId = "group_user")
    public void createUser(String userJSON) {
        log.info("Consumed message of user: " + userJSON);
        try {
            if (!userJSON.isEmpty()) {
                User user = JSON_MAPPER.readValue(userJSON, User.class);
                userRepository.save(user);
            }
        } catch (JsonProcessingException e) {
            String errorMsg = "Failed to parse User JSON!";
            log.error(errorMsg, e);
            throw new BadRequestException("invalid-request", errorMsg, e);
        }

/*        List<User> userList = userRepository.findAll().;
        for (User user : userList) {
            log.info(user.getFirstName());
        }*/
    }
}
