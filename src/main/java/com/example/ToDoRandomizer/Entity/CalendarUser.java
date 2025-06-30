package com.example.ToDoRandomizer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CalendarUser {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "calendarUser")
    private Calendar calendar;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expectedTime_id")
    private ExpectedTime attentionSpan;
}
