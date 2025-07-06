package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
    
    @Query("SELECT g FROM Goal g WHERE g.calendarUser.id = :userId")
    List<Goal> findGoalsByUserId(@Param("userId") Integer userId);
    
    @Query("SELECT t FROM Task t JOIN LinkedTask lt ON t.id = lt.task.id JOIN Goal g ON lt.id = g.currentLinkTask.id WHERE g.calendarUser.id = :userId")
    Optional<Task> findCurrentTaskByUserId(@Param("userId") Integer userId);
    
    @Query("SELECT t FROM Task t JOIN LinkedTask lt ON t.id = lt.task.id JOIN Goal g ON lt.id IN (g.firstLinkedTask.id, g.currentLinkTask.id, g.lastLinkedTask.id) WHERE g.calendarUser.id = :userId AND t.completed = false ORDER BY RAND() LIMIT 1")
    Optional<Task> findRandomTaskByUserId(@Param("userId") Integer userId);
} 