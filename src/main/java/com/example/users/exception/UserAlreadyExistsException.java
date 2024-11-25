package com.example.users.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(Integer id) {
        super("User with ID " + id + " already exists.");
    }
}
