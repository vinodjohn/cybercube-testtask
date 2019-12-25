package com.example.consumer.repository;

import com.example.consumer.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to read and write user data
 *
 * @author Vinod John
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
