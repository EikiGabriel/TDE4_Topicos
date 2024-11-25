package com.example.users.service;

import com.example.users.dto.CreateUserDto;
import com.example.users.dto.UpdateUserDto;
import com.example.users.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    List<User> getAllUsers();
    User createUser(CreateUserDto createUserDto);
    User updateUser(Integer id, UpdateUserDto updateUserDto);
    void deleteUser(Integer id);
}
