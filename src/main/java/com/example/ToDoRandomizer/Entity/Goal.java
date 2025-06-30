package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Duration;

public class Goal {
    @Id
    @GeneratedValue
    private Integer id;
    private User user;
    private Calendar calendar;
    private LinkedTask currentLinkTask;
    private LinkedTask lastLinkedTask;
    private LinkedTask firstLinkedTask;
    private String description;
    private String actualGoalDescription;
    private Duration expectedCompletionDuration;
    private Duration actualDuration;
    private Boolean completed;

}
