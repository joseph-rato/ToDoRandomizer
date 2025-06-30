package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnboardRepository extends JpaRepository<CalendarUser, Integer> {
}
