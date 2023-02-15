package com.example.Todolist.service;

import com.example.Todolist.domain.Task;
import com.example.Todolist.domain.ToDoList;
import com.example.Todolist.repository.TaskRepository;
import com.example.Todolist.repository.ToDoListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final TaskRepository taskRepository;

    public ToDoListService(ToDoListRepository toDoListRepository, TaskRepository taskRepository) {
        this.toDoListRepository = toDoListRepository;
        this.taskRepository = taskRepository;
    }

    public List<ToDoList> getAll() {
        return toDoListRepository.findAll();
    }

    public ToDoList saveList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    public ToDoList addTaskInList(Long listId, Long taskId) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(listId);
        Optional<Task> task = taskRepository.findById(taskId);
        if(toDoList.isPresent()&&task.isPresent()){
            toDoList.get().getTasks().add(task.get());
            task.get().getList().add(toDoList.get());
//            taskRepository.save(task.get());
            ToDoList savedList =  toDoListRepository.save(toDoList.get());
            taskRepository.save(task.get());
            return toDoList.get();
        }
        throw  new RuntimeException("List does not Exist!");
    }

    public List<ToDoList> deleteTaskFromList(Long listId, Long taskId) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(listId);
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()&&toDoList.isPresent()){
//            toDoList.get().getTasks().remove(task.get());
            task.get().getList().remove(toDoList.get());
//            System.out.println();
            toDoListRepository.save(toDoList.get());
            taskRepository.save(task.get());
            return toDoListRepository.findAll();
        }
        throw  new RuntimeException("Task was not deleted");
    }

    public ToDoList getByName(String name) {
        return toDoListRepository.getByName(name);
    }
}
