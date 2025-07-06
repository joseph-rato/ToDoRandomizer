package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Repository.AdhdAssistantRepository;
import com.example.ToDoRandomizer.Repository.GoalRepository;
import com.example.ToDoRandomizer.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<Task> getRandomTask(Integer id) {
        List<Task> currentTasks = goalRepository.findAllCurrentTasksByUserId(id);
        if (currentTasks.isEmpty()) {
            throw new RuntimeException("No current tasks found for user: " + id);
        }
        // need to get random task from current tasks
        Random random = new Random();
        int randomIndex = random.nextInt(currentTasks.size());
        Task randomTask = currentTasks.get(randomIndex);
        // need to set random task to current task
        goalRepository.setCurrentTask(id, randomTask.getId());
        randomTask.setActiveTask(true);
        taskRepository.save(randomTask);
        return currentTasks;
    }

    public List<Goal> getGoals(Integer userId) {
        // need to get all goals for the user
        return goalRepository.findGoalsByUserId(userId);
    }

    public Goal setGoal(Goal goal) {
        // need to set current goal to inactive and then set new goal to active
        return goalRepository.save(goal);
    }

    @Transactional
    public Task setCurrentTask(Integer userId, Integer newTaskId) {
        // Find the current active task ID for the user
        Optional<Integer> currentTaskId = goalRepository.findCurrentTaskIdByUserId(userId);
        
        if (currentTaskId.isPresent()) {
            // Get the current task and mark it as not active (completed)
            Task currentTask = taskRepository.findById(currentTaskId.get())
                    .orElseThrow(() -> new RuntimeException("Current task not found"));
            currentTask.setActiveTask(false);
            taskRepository.save(currentTask);
        }
        
        // Verify the new task exists
        Task newTask = taskRepository.findById(newTaskId)
                .orElseThrow(() -> new RuntimeException("New task not found with id: " + newTaskId));
        
        // Update the goal to point to the new task as current
        goalRepository.setCurrentTask(userId, newTaskId);
        
        // Mark the new task as active (not completed)
        newTask.setActiveTask(true);
        taskRepository.save(newTask);
        
        return newTask;
    }

    
}
