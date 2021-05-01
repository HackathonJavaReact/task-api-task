package com.api.task.taskapi.repositories;

import com.api.task.taskapi.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    
    
}
