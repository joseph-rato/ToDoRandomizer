package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;

public class LinkedTask {
    @Id
    @Column(name="linkedTask_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linkedTask_id")
    private LinkedTask nextTask;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linkedTask_id")
    private LinkedTask previousTask;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;
}
