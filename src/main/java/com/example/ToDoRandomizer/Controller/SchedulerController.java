package com.example.ToDoRandomizer.Controller;

import com.example.ToDoRandomizer.Entity.Appointment;
import com.example.ToDoRandomizer.Entity.Calendar;
import com.example.ToDoRandomizer.Service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
    private final SchedulerService schedulerService;

    @Autowired
    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping("/createCalendar")
    public ResponseEntity addCalendar(@RequestBody Calendar calendar){
        Calendar newCalendar = schedulerService.addCalendar(calendar);
        return ResponseEntity.ok(newCalendar);
    }

//    might need dto depending on if we can provide an id for calendar
    @PostMapping("/createAppointment")
    public ResponseEntity addAppointment(@RequestBody Appointment appointment){
        Appointment newAppointment= schedulerService.addAppointment(appointment);
        return ResponseEntity.ok(newAppointment);
    }
}
