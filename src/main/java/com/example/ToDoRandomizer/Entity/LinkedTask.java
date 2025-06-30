package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class LinkedTask {
    @Id
    @GeneratedValue
    private Integer id;
    private LinkedTask nextTask;
    private LinkedTask previousTask;
    private Task task;
}
