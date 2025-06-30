package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private Integer id;
    private Instant startTime;
    private Instant endTime;
    private ExpectedTime expectedTime;
    private Duration actualTime;
    private Duration currentTime;
    private String description;
    private Boolean completed;
    private String Notes;
}
