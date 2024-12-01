package com.app.todoapp.service.serviceImpl;

import com.app.todoapp.entities.Task;
import com.app.todoapp.repository.TaskRepository;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public void saveTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

    @Override
    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid parameter"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);


    }
}
