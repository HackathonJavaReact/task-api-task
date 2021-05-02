package com.api.task.taskapi.repositories;

import java.util.List;

import com.api.task.taskapi.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserId(Long userId); // TODO: test Query or write Query
    
}
