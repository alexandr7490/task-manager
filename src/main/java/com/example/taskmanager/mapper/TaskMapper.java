package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.task.TaskResponse;
import com.example.taskmanager.DTO.user.UserResponse;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.User;

public class TaskMapper {
private final UserMapper userMapper;

    public TaskMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public TaskResponse toResponse(Task task) {
        if (task == null) return null;

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .assignee(convertAssignee(task.getAssignee()))
                .projectId(task.getProject().getId())
                .projectTitle(task.getProject().getTitle())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }

    private UserResponse convertAssignee(User assignee) {
        if (assignee == null) {
            return null;
        }
        return userMapper.toResponse(assignee);
    }


}
