package com.example.users.exception;

public class PostNotFoundException extends RuntimeException {
  public PostNotFoundException(Integer id) {
    super("Post with ID " + id + " not found.");
  }
}
