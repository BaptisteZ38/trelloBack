package com.example.backTrelloBis.exception;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public ResourceException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
