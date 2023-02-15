package com.example.Todolist.repository;

import com.example.Todolist.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {
    public ToDoList getByName(String name);
}
