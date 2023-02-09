package com.example.javaback.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApplicationStatusException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
