package com.example.ToDoRandomizer.Controller;

import com.example.ToDoRandomizer.Entity.Goal;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Service.ManifestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manifestor/v1")
public class ManifestorController {

    private final ManifestorService manifestorService;

    @Autowired
    public ManifestorController(ManifestorService manifestorService) {
        this.manifestorService = manifestorService;
    }

    @PostMapping("/addGoal")
    public ResponseEntity addGoal(@RequestBody Goal goal) {
        Goal newGoal = manifestorService.addGoal(goal);
        return ResponseEntity.ok(newGoal);
    }

    @PostMapping("/addTask")
    public ResponseEntity addTask(@RequestBody Task task) {
        Task newTask = manifestorService.addTask(task);
        return ResponseEntity.ok(newTask);
    }
}
