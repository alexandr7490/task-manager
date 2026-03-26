package com.example.taskmanager.DTO.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectShortResponse {

    private Long id;
    private String title;
    private String description;

    private int taskCount;                    // количество задач в проекте
    private LocalDateTime createdAt;
}
