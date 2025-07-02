package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository  extends JpaRepository<Calendar, Integer> {
}
