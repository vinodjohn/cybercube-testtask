package com.example.consumer.service;

/**
 * Service interface for user related logics
 *
 * @author Vinod John
 */
public interface UserService {

    /**
     * Listener to create new user.
     *
     * @param userJSON
     */
    void createUser(String userJSON);
}
