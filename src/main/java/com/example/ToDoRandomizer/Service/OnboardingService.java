package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Repository.OnboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnboardingService {
    @Autowired
    OnboardRepository onboardRepository;

    public CalendarUser addCalendarUser(CalendarUser calendarUser) {
        return onboardRepository.save(calendarUser);
    }
}
