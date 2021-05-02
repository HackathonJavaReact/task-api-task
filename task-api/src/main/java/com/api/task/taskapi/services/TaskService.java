package com.api.task.taskapi.services;

import java.util.List;

import com.api.task.taskapi.entities.Task;
import com.api.task.taskapi.exceptions.DatabaseException;
import com.api.task.taskapi.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired TaskRepository repository;

    public List<Task> getList() throws DatabaseException {
        return this.repository.findAll();
    }

    public Task getById(Long id) throws DatabaseException {
        return this.repository.findById(id).get();
    }

    public Task create(Task task) throws DatabaseException {
        return this.repository.save(task);
    }

    public List<Task> getByUserId(Long userId) throws DatabaseException {
        return this.repository.findByUserId(userId);
    }
    
}
