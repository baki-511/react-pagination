package com.tutorial.exception;

import com.tutorial.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> tutorialNotFoundExceptionHandler(TutorialNotFoundException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);
    }
}
