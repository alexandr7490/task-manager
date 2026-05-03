package com.example.taskmanager.service;

import com.example.taskmanager.DTO.user.CreateUserRequest;
import com.example.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Override
    public User createUser(CreateUserRequest request) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
