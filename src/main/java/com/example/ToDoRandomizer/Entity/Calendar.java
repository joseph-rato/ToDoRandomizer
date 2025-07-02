package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
    @Id
    @Column(name="calendar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "calendar")
    private CalendarUser calendarUser;
    @OneToMany(mappedBy = "appointment_id", cascade = CascadeType.ALL)
    private ArrayList<Appointment> appointments;
    private String name;
    private String description;
}
