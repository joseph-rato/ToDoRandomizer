package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.TimestampUtcAsInstantJdbcType;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

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
    private int id;
    private Optional<Instant> startTime;
    private Optional<Instant> endTime;
    private Optional<ExpectedTime> expectedTime;
    private Optional<Duration> actualTime;
    private Optional<Optional> currentTime;
    private String description;
    private Boolean completed;
    private String Notes;
}
