package com.example.iticket.ticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`Ticket`")
public class Ticket {
    @Id
    private UUID id;
    private String name;
    private double price;
    private UUID blockId;
    private UUID eventId;
}
