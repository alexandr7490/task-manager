package com.example.taskmanager.DTO.task;

import com.example.taskmanager.entity.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskRequest {
    @Size(min = 3, max = 200, message = "Название должно быть от 3 до 200 символов")
    private String title;

    @Size(max = 1000)
    private String description;

    private TaskStatus status;

    private Long assigneeId;
}
