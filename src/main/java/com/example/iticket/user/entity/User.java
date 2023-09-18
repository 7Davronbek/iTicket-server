package com.example.iticket.user.entity;

import com.example.iticket.booking.entity.Booking;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`User`")
public class User {
    @Id
    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private UserType userType;
//    private List<Booking> bookings;
}
