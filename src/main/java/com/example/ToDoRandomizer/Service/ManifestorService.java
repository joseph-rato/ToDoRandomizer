package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Repository.ManifestorRepository;
import com.example.ToDoRandomizer.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManifestorService {

    @Autowired
    private ManifestorRepository manifestorRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    public Goal addGoal(Goal goal) {
        return manifestorRepository.save(goal);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

}
