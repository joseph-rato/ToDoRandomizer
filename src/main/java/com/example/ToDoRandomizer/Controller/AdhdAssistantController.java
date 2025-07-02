package com.example.ToDoRandomizer.Controller;

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
    public ResponseEntity getSchedule(@RequestParam Integer id) {

    }

    @GetMapping("/getCurrentTask")
    public ResponseEntity getCurrentTask(@RequestParam Integer id) {

    }

    @GetMapping("/getRandomTask")
    public ResponseEntity getRandomTask(@RequestParam Integer id) {

    }

    @GetMapping("/getGoals")
    public ResponseEntity getGoals(@RequestParam Integer id) {

    }

    @PostMapping("/setGoal")
    public ResponseEntity setGoal(@RequestParam Integer id) {

    }
}
