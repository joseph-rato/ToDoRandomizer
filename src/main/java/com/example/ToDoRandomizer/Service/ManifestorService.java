package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.LinkedTask;
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

    // TODO: link this task to the correct goal
    public Task linkTaskToGoal(Task task, Goal goal) {
        Task newTask  = addTask(task);
        LinkedTask lastLinkedTask = goal.getLastLinkedTask();
        LinkedTask newLastLinkedTask = generateLastLinkedTask(newTask, lastLinkedTask);
        goal.setLastLinkedTask(newLastLinkedTask);
        manifestorRepository.save(goal);
        return task;
    }

    LinkedTask generateLastLinkedTask(Task task, LinkedTask previousLastTask) {
        LinkedTask linkedTask = new LinkedTask();
        linkedTask.setTask(task);
        linkedTask.setNextTask(null);
        linkedTask.setPreviousTask(previousLastTask);
        return linkedTask;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

}
