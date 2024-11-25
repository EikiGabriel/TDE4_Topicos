package com.example.users.service;

import com.example.users.dto.CreateUserDto;
import com.example.users.dto.UpdateUserDto;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setAge(createUserDto.age());
        user.setName(createUserDto.name());
        user.setEmail(createUserDto.email());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, UpdateUserDto updateUserDto) {
        User existingUser = getUserById(id);
        existingUser.setName(updateUserDto.name());
        existingUser.setEmail(updateUserDto.email());
        existingUser.setAge(updateUserDto.age());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
