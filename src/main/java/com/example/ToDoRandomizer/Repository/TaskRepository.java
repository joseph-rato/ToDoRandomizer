package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
} 