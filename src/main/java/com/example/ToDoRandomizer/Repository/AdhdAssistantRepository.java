package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdhdAssistantRepository extends JpaRepository<CalendarUser, Integer> {
}
