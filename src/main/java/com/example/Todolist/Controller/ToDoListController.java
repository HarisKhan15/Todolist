package com.example.Todolist.Controller;


import com.example.Todolist.domain.Task;
import com.example.Todolist.domain.ToDoList;
import com.example.Todolist.service.ToDoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/list")
    private ResponseEntity<List<ToDoList>> getAll(){
        return ResponseEntity.ok(toDoListService.getAll());
    }

    @GetMapping("/list/{name}")
    private ResponseEntity<ToDoList> getByName(@PathVariable String name){
        return ResponseEntity.ok(toDoListService.getByName(name));
    }
    @PostMapping("/list")
    private ResponseEntity<ToDoList> save(@RequestBody ToDoList toDoList){
        return ResponseEntity.ok(toDoListService.saveList(toDoList));
    }

    @PutMapping("/list/{listId}/{taskId}")
    private ResponseEntity<ToDoList> addTaskInList(@PathVariable Long listId,@PathVariable Long taskId){
        return ResponseEntity.ok(toDoListService.addTaskInList(listId,taskId));
    }


    @DeleteMapping("/list/{listId}/{taskId}")
    private ResponseEntity<List<ToDoList>> deleteTaskFromList(@PathVariable Long listId,@PathVariable Long taskId){
        return ResponseEntity.ok(toDoListService.deleteTaskFromList(listId,taskId));
    }
}
