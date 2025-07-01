package com.example.ToDoRandomizer.Service;

public class AlreadyExistsError extends Exception {
    public AlreadyExistsError(String message) {
        super(message);
    }
}
