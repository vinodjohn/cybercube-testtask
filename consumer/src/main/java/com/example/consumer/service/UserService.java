package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @KafkaListener(topics = "users", groupId = "group_user")
    public void consume(String message) {
        System.out.println("Consumed msg: " + message);
    }
}
