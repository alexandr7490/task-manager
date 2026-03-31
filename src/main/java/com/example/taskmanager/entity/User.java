package com.example.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password", "tasks", "projects"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @EqualsAndHashCode.Include
    private String username;

    @NotBlank
    @Email
    @EqualsAndHashCode.Include
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)     // Роль обычно нужна всегда
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "assignee", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Version
    private Long version;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
