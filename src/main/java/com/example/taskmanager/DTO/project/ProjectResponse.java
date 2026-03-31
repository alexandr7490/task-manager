package com.example.taskmanager.DTO.project;

import com.example.taskmanager.DTO.user.UserShortResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long id;
    private String title;
    private String description;

    private List<UserShortResponse> users;     // участники проекта

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
