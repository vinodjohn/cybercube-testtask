package com.example.producer.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;

/**
 * Custom exception base for REST API exceptions that are related to invalid/missing/incorrect data in the request.
 *
 * @author Vinod John
 */
@Getter
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;
    private Collection<String> subCodes;

    public BadRequestException(String message) {
        this(null, null, message);
    }

    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BadRequestException(String code, Collection<String> subCodes, String message) {
        super(message);
        this.code = code;
        this.subCodes = subCodes;
    }

    public BadRequestException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BadRequestException(String code, Collection<String> subCodes, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.subCodes = subCodes;
    }
}
