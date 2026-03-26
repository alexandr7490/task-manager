package com.example.taskmanager.service;

import com.example.taskmanager.DTO.user.CreateUserRequest;
import com.example.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(CreateUserRequest request);
    User getUserById(Long id);
    List<User> getAllUsers();
    Optional<User> findByUsername(String username);
}
