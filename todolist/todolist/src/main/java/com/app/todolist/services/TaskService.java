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

    public void createTask(String title) {
        Task task = new Task(null, title, false);
        // task.withTitle(title); dont actually need this if we set a constructor for the new task instances
        // task.withCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Integer id) {
        taskRepository.updateById(id);
    }

}
