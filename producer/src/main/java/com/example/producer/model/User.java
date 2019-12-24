package com.example.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Model class for a user
 *
 * @author Vinod John
 */
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonIgnore
    private String applicationName;
}
