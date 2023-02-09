package com.example.javaback.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationStatusException.class)
    public ResponseEntity<String> handleApplicationException(ApplicationStatusException e) {
        log.error("Ошибка {}:{}", e.getStatus().value(), e.getMessage(), e);
        return ResponseEntity
                .status(e.getStatus().value())
                .body(e.getMessage());
    }
}
