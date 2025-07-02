package com.example.ToDoRandomizer.DataTransferObjects;

import com.example.ToDoRandomizer.Entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAppointment extends Appointment {
    private Integer userId;
}
