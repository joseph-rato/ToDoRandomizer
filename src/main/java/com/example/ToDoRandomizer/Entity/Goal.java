package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;

import java.time.Duration;

public class Goal {
    @Id
    @Column(name="goal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private CalendarUser calendarUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linkedTask_id")
    private LinkedTask currentLinkTask;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linkedTask_id")
    private LinkedTask lastLinkedTask;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linkedTask_id")
    private LinkedTask firstLinkedTask;
    private String description;
    private String actualGoalDescription;
    private Duration expectedCompletionDuration;
    private Duration actualDuration;
    private Boolean completed;

}
