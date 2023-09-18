package com.example.iticket.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`Booking`")
public class Booking {
    @Id
    private UUID bookId;
    private UUID ticketId;
    private UUID userId;

}
