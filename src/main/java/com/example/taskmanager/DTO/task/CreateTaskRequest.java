package com.example.taskmanager.DTO.task;

import com.example.taskmanager.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequest {

    @NotBlank
    @Size(min = 3, max = 200)
    private String title;

    @Size(max = 1200)
    private String description;

    @NotNull
    private TaskStatus status = TaskStatus.TODO;

    private String assigneeName;
    private String projectName;
}
