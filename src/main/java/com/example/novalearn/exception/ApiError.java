package com.example.novalearn.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiError {
    private int errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;

    public ApiError(int errorCode, String errorMessage, LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }
}
