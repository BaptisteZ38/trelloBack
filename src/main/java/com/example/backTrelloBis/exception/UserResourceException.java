package com.example.backTrelloBis.exception;

import org.springframework.http.HttpStatus;

public class UserResourceException extends ResourceException {

    public UserResourceException(String errorCode, String message, HttpStatus status) {
        super(errorCode, message, status);
    }
}