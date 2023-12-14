package com.example.demo.errors;

public class SortDoesNotExistException extends RuntimeException{
    public SortDoesNotExistException(String sort){
        super(String.format("Sort '%s' does not exist", sort));
    }
}
