package com.api.task.taskapi.controllers;

import java.util.List;

import com.api.task.taskapi.entities.Task;
import com.api.task.taskapi.exceptions.DatabaseException;
import com.api.task.taskapi.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired TaskService service;

    @GetMapping
    public ResponseEntity<?> getTasks() {
        try {
            List<Task> tasks = this.service.getList();
            return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        try {
            Task task = this.service.getById(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            Task t = this.service.create(task);
            return new ResponseEntity<Task>(t, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ofuser/{userId}")
    public ResponseEntity<?> getTasksByUserId(@PathVariable Long userId) {
        try {
            List<Task> tasks = this.service.getByUserId(userId);
            return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
