package com.example.ToDoRandomizer.Service;

import com.example.ToDoRandomizer.DataTransferObjects.NewAppointment;
import com.example.ToDoRandomizer.Entity.Appointment;
import com.example.ToDoRandomizer.Entity.Calendar;
import com.example.ToDoRandomizer.Entity.Task;
import com.example.ToDoRandomizer.Repository.SchedulerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    SchedulerRepository schedulerRepository;

    public Calendar addCalendar(Calendar calendar) {
        return schedulerRepository.save(calendar);
    }

    public Appointment addAppointment(Appointment appointment) {
        Calendar originalCalendar = schedulerRepository.findById(appointment.getCalendar().getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        originalCalendar.getAppointments().add(appointment);
        Calendar newCalendar = schedulerRepository.save(originalCalendar);
        return newCalendar.getAppointments().getLast();
    }
}
