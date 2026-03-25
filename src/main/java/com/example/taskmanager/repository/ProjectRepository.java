package com.example.taskmanager.repository;
import com.example.taskmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByTitle(String title);
    boolean existsByTitle(String title);


}
