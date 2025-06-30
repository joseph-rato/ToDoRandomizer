package com.example.ToDoRandomizer.Controller;

import com.example.ToDoRandomizer.Entity.User;
import com.example.ToDoRandomizer.Service.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onboard/v1")
public class OnboardController {

    private final OnboardingService onboardingService;

    @Autowired
    public OnboardController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user){
        User newUser = onboardingService.addUser(user);
        return ResponseEntity.ok(newUser);
    };


}
