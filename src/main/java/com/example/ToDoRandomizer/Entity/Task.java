package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;

//TODO: might be worth pulling out all the optional Time blocks here
// to a different class to be used when Task is actually started

//TODO: might be worth adding a class that can timestamp when and what happened for rollback etc could be used for notes

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant startTime;
    private Instant endTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expectedTime_id")
    private ExpectedTime expectedTime;
    private Duration actualTime;
    private Duration currentTime;
    private Instant currentTimeStart;
    private String description;
    private Boolean activeTask;
    private Boolean completed;
    private String Notes;
}
