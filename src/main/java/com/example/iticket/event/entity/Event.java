package com.example.iticket.event.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String name;
    private String description;
    private int age;
    private LocalDate time;
    private UUID hallID;
    private UUID organizerID;
}
