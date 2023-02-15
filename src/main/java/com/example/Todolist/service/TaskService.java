package com.example.Todolist.service;

import com.example.Todolist.domain.Task;
import com.example.Todolist.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        if(taskRepository.getByDescriptionAndComment(task.getDescription(),task.getComment())==null){
            return taskRepository.save(task);
        }
        throw new RuntimeException("Duplicate Task!");
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getByDescriptionAndComment(String description,String comment) {
        return taskRepository.getByDescriptionAndComment(description,comment);
    }
}
