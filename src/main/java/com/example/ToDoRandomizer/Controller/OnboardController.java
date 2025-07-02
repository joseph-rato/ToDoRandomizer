package com.example.ToDoRandomizer.Controller;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Exceptions.AlreadyExistsError;
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
    public ResponseEntity addUser(@RequestBody CalendarUser calendarUser){
        CalendarUser newCalendarUser = onboardingService.addCalendarUser(calendarUser);
        return ResponseEntity.ok(newCalendarUser);
    };

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody CalendarUser calendarUser) throws AlreadyExistsError {
        CalendarUser updatedCalendarUser = onboardingService.updateCalendarUser(calendarUser);
        return ResponseEntity.ok(updatedCalendarUser);
    };

}
