package com.example.novalearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RegisterAccountTypeError extends ResponseStatusException{

    public RegisterAccountTypeError(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
