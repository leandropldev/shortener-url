package com.devstack.shortnerurl.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GenericAPIException extends RuntimeException {
    public GenericAPIException(String message) {
        super(message);
    }}
