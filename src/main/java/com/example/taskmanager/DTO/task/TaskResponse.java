package com.example.taskmanager.DTO.task;

import com.example.taskmanager.DTO.user.UserResponse;
import com.example.taskmanager.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    private UserResponse assignee;//можно сделать короткий ответ

    private Long projectId;
    private String projectTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
