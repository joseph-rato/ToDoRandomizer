package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Repository.AdhdAssistantRepository;
import com.example.ToDoRandomizer.Repository.GoalRepository;
import com.example.ToDoRandomizer.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdhdAssistantService {

    @Autowired
    private AdhdAssistantRepository adhdAssistantRepository;
    
    @Autowired
    private GoalRepository goalRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    public CalendarUser getSchedule(Integer id) {
        return adhdAssistantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Task getCurrentTask(Integer id) {
        Optional<Task> currentTask = goalRepository.findCurrentTaskByUserId(id);
        return currentTask.orElseThrow(() -> new RuntimeException("No current task found for user: " + id));
    }

    public Task getRandomTask(Integer id) {
        Optional<Task> randomTask = goalRepository.findRandomTaskByUserId(id);
        return randomTask.orElseThrow(() -> new RuntimeException("No tasks available for user: " + id));
    }

    public List<Goal> getGoals(Integer id) {
        return goalRepository.findGoalsByUserId(id);
    }

    public Goal setGoal(Goal goal) {
        return goalRepository.save(goal);
    }
}
