package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpectedTime {
    @Id
    @Column(name="expectedTime_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Duration userAssumed;
    private Duration taskAverage;
    private Boolean useCalculatedAverage;
}
