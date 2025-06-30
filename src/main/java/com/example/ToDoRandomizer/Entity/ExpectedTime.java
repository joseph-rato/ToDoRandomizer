package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private Integer id;
    private Duration userAssumed;
    private Duration taskAverage;
    private Boolean useCalculatedAverage;
}
