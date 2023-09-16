package com.example.iticket.event.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`Event`")
public class Event {
    @Id
    private UUID id;
    private String name;
    private String description;
    private int age;
    private LocalDate time;
    private UUID hallID;
    private UUID organizerID;
}
