package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends Task {
    @Id
    @Column(name="appointment_id")
    @GeneratedValue
    private Integer id;
    private Boolean alert;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id", nullable = false) // Define the foreign key column name
    private Calendar calendar;
    private Boolean specificEvent;
}
