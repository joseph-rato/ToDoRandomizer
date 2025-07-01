package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.Entity.CalendarUser;
import com.example.ToDoRandomizer.Repository.OnboardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnboardingService {
    @Autowired
    OnboardRepository onboardRepository;

    public CalendarUser addCalendarUser(CalendarUser calendarUser) {
        return onboardRepository.save(calendarUser);
    }

    public CalendarUser updateCalendarUser(CalendarUser calendarUser) throws AlreadyExistsError {
        CalendarUser originalCalendarUser = onboardRepository.findById(calendarUser.getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (!calendarUser.equals(originalCalendarUser)) {
            return onboardRepository.save(calendarUser);
        }
        else {
            throw new AlreadyExistsError("Calendar user already exists with those exact details");
        }
    }
}
