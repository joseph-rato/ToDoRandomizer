package com.example.ToDoRandomizer.Exceptions;

public class AlreadyExistsError extends Exception {
    public AlreadyExistsError(String message) {
        super(message);
    }
}
