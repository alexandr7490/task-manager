package com.example.taskmanager.DTO.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectRequest {
    @NotBlank// check проверь, не портит ли builder not blank
    @Size(min = 3, max = 200)
    private String title;

    @Size(max = 1200)
    private String description;
}
