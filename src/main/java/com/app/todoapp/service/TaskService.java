package com.app.todoapp.service;

import com.app.todoapp.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    void deleteTask(Long id);

    void saveTask(String title);

    void toggleTask(Long id);
}
