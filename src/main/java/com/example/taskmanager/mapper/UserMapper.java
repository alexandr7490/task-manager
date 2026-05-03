package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.user.UserResponse;
import com.example.taskmanager.DTO.user.UserShortResponse;
import com.example.taskmanager.entity.User;

public class UserMapper {
    public UserResponse toResponse(User user) {
        if (user == null) return null;

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole().getName() : null)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserShortResponse toShortResponse(User user) {
        if (user == null) return null;

        return UserShortResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
