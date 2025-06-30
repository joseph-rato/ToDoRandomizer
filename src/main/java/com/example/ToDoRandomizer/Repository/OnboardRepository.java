package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnboardRepository extends JpaRepository<User, Integer> {
}
