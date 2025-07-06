package com.example.ToDoRandomizer.Controller;

import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Service.AdhdAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AdhdAssistant/v1")
public class AdhdAssistantController {

    private final AdhdAssistantService adhdAssistantService;

    @Autowired
    public AdhdAssistantController(AdhdAssistantService adhdAssistantService) {
        this.adhdAssistantService = adhdAssistantService;
    }

    @GetMapping("/getSchedule")
    public ResponseEntity getSchedule(@RequestParam Integer userId) {
        return ResponseEntity.ok(adhdAssistantService.getSchedule(userId));
    }

    @GetMapping("/getCurrentTask")
    public ResponseEntity getCurrentTask(@RequestParam Integer userId) {
        return ResponseEntity.ok(adhdAssistantService.getCurrentTask(userId));
    }

    @GetMapping("/setCurrentTask")
    public ResponseEntity setCurrentTask(@RequestParam Integer userId, @RequestParam Integer newTaskId) {
        return ResponseEntity.ok(adhdAssistantService.setNewTaskToInProgress(userId, newTaskId));
    }

    @GetMapping("/getRandomTask")
    public ResponseEntity getRandomTask(@RequestParam Integer userId) {
        return ResponseEntity.ok(adhdAssistantService.setRandomTaskToInProgress(userId));
    }

    @GetMapping("/getGoals")
    public ResponseEntity getGoals(@RequestParam Integer userId) {
        return ResponseEntity.ok(adhdAssistantService.getGoals(userId));
    }

    @PostMapping("/setGoal")
    public ResponseEntity setGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok(adhdAssistantService.setGoal(goal));
    }
}
