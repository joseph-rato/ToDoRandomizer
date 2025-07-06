package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarUserRepository extends JpaRepository<CalendarUser, Integer> {
}
