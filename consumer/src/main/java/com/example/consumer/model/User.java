package com.example.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

/**
 * Model class for a user
 *
 * @author Vinod John
 */
@Getter
@Setter
@RedisHash("user")
@EqualsAndHashCode
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("application_name")
    private String applicationName;
}
