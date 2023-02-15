package com.example.Todolist.Controller;

import com.example.Todolist.domain.Task;
import com.example.Todolist.domain.ToDoList;
import com.example.Todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    private ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }
    @PostMapping("/task")
    private ResponseEntity<Task> save(@RequestBody Task task){
        return ResponseEntity.ok(taskService.save(task));
    }
    @GetMapping("/task/{description}/{comment}")
    private ResponseEntity<Task> getByName(@PathVariable String description,@PathVariable String comment){
        return ResponseEntity.ok(taskService.getByDescriptionAndComment(description,comment));
    }
}
