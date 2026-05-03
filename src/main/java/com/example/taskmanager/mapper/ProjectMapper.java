package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.project.ProjectResponse;
import com.example.taskmanager.DTO.project.ProjectShortResponse;

import com.example.taskmanager.DTO.user.UserShortResponse;
import com.example.taskmanager.entity.Project;
import com.example.taskmanager.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMapper {
    private final UserMapper userMapper;   // внедряем UserMapper для преобразования пользователей

    public ProjectMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ProjectResponse toResponse(Project project){
        if (project == null) return null;

        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .users(convertUsers(project.getUsers()))
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }

    public ProjectShortResponse toShortResponse(Project project){
        if (project == null) return null;

        return ProjectShortResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .taskCount(project.getTasks().size())
                .createdAt(project.getCreatedAt())
                .build();
    }


    private List<UserShortResponse> convertUsers(Set<User> users) {
        if (users == null) {
            return List.of();
        }

        return users.stream()
                .map(userMapper::toShortResponse)
                .collect(Collectors.toList());
    }
}
