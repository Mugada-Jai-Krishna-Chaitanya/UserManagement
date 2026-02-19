package com.example.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UserErrorResponse exceptionable(UserNotFoundException e){
        UserErrorResponse userErrorResponse = new UserErrorResponse();

        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage(e.getMessage());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime time=LocalDateTime.now();

        userErrorResponse.setTimeStamp(time.format(formatter));

        return userErrorResponse;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserErrorResponse exceptionable(Exception e){
        UserErrorResponse userErrorResponse = new UserErrorResponse();

        userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        userErrorResponse.setMessage(e.getMessage());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime time=LocalDateTime.now();

        userErrorResponse.setTimeStamp(time.format(formatter));

        return userErrorResponse;
    }

}
