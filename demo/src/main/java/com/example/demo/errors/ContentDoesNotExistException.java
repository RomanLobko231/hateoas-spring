package com.example.demo.errors;

public class ContentDoesNotExistException extends RuntimeException{

    public ContentDoesNotExistException(Long id) {
        super("A content with id '%s' does not exist".formatted(id));
    }
}
