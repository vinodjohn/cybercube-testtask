package com.example.producer.service;

/**
 * Service interface for Kafka Producer logic
 *
 * @author Vinod John
 */
public interface MessageService {

    /**
     * To send message based on topic
     *
     * @param topic topic key
     * @param message message to be sent
     */
    void sendMessage(String topic, String message);
}
