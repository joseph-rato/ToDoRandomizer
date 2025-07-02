package com.example.ToDoRandomizer.Repository;

import com.example.ToDoRandomizer.Entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManifestorRepository extends JpaRepository<Goal, Integer> {
}
