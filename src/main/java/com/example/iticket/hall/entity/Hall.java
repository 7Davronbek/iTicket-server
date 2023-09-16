package com.example.iticket.hall.entity;

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
@Table(name = "`Hall`")
public class Hall {
    @Id
    private UUID id;
    private String country;
    private String region;
    private String city;
    private String buildingName;
    private UUID ownerId;
    private int capacity;
}
