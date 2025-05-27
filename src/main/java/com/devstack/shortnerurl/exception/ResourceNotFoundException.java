package com.devstack.shortnerurl.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends GenericAPIException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
