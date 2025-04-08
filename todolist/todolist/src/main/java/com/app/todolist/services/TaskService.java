package com.app.todolist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todolist.models.Task;
import com.app.todolist.models.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
       return taskRepository.findAll();
    }

}
