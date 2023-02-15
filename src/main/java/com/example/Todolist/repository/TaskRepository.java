package com.example.Todolist.repository;

import com.example.Todolist.domain.Task;
import com.example.Todolist.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    public Task getByDescription(String description);
    public Task getByDescriptionAndComment(String description,String comment);
}
