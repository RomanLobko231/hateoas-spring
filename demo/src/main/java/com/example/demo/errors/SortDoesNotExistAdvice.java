package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SortDoesNotExistAdvice {

    @ResponseBody
    @ExceptionHandler(SortDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String sortDoesNotExistHandler(SortDoesNotExistException ex) {
        return ex.getMessage();
    }
}
