package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Repository.CalendarUserRepository;
import com.example.ToDoRandomizer.Repository.GoalRepository;
import com.example.ToDoRandomizer.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdhdAssistantService {

    @Autowired
    private CalendarUserRepository calendarUserRepository;
    
    @Autowired
    private GoalRepository goalRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    public CalendarUser getSchedule(Integer id) {
        return calendarUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Task getCurrentTask(Integer id) {
        Optional<Task> currentTask = goalRepository.findCurrentTaskByUserId(id);
        return currentTask.orElseThrow(() -> new RuntimeException("No current task found for user: " + id));
    }

    @Transactional
    public Task setRandomTaskToInProgress(Integer id) {
        List<Task> currentTasks = goalRepository.findAllCurrentTasksByUserId(id);
        if (currentTasks.isEmpty()) {
            throw new RuntimeException("No current tasks found for user: " + id);
        }
        // need to get random task from current tasks
        Random random = new Random();
        int randomIndex = random.nextInt(currentTasks.size());
        Task randomTask = currentTasks.get(randomIndex);
        // need to set random task to current task
        Task savedTask = setTaskToInProgress(randomTask);
        return savedTask;
    }

    public List<Goal> getGoals(Integer userId) {
        // need to get all goals for the user
        return goalRepository.findGoalsByUserId(userId);
    }

    public Goal setGoal(Goal goal) {
        // need to set current goal to inactive and then set new goal to active
        return goalRepository.save(goal);
    }

    // TODO: NEED TO HAVE METHOD THAT corrects goals to being correct. after save, after update
    // TODO: this method for manipulating goal should also have ways to update goal with correct times etc 

    // might need two methods but for sure for setting new random task to in progress

    @Transactional
    public Task setNewTaskToInProgress(Integer userId, Integer newTaskId) {
        Task currentTask = getCurrentTask(userId);
        setTaskToNotInProgress(currentTask);
        
        // Verify the new task exists
        Task newTask = taskRepository.findById(newTaskId)
                .orElseThrow(() -> new RuntimeException("New task not found with id: " + newTaskId));
        
        // Update the goal to point to the new task as current
        goalRepository.setCurrentTask(userId, newTaskId);
        
        // Mark the new task as active (not completed)
        Task savedTask = setTaskToInProgress(newTask);
        
        return savedTask;
    }

    private Duration calculateCurrentTime(Task task) {
        Duration currentTotalTime=task.getCurrentTime();
        return currentTotalTime.plus(Duration.between(task.getCurrentTimeStart(), Instant.now()));
    }

    public Task setTaskCompleted(Integer userId, Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        task.setEndTime(Instant.now());
        Duration totalTime = calculateCurrentTime(task);
        task.setCurrentTime(totalTime);
        task.setActualTime(totalTime);
        task.setActiveTask(false);
        task.setCompleted(true);
        task.setEndTime(Instant.now());
        taskRepository.save(task);
        return task;
    }

    public Task setTaskToInProgress(Task task) {
        task.setActiveTask(true);
        task.setCurrentTimeStart(Instant.now());
        taskRepository.save(task);
        return task;
    }

    public Task setTaskToNotInProgress(Task task) {
        task.setActiveTask(false);
        task.setCurrentTime(calculateCurrentTime(task));
        task.setCurrentTimeStart(null);
        taskRepository.save(task);
        return task;
    }
}
