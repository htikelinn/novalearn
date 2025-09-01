package com.example.novalearn.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler({RegisterAccountTypeError.class})
    public ResponseEntity<Object> exceptionHandler(Exception ex,WebRequest request) throws Throwable{
        return handleExceptionInternal(ex, message(ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        
    }
    private ApiError message(Exception ex) {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
    }
    
}
