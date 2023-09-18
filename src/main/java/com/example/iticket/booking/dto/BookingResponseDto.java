package com.example.iticket.booking.dto;

import lombok.*;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto extends BookingBaseDto{
    private UUID bookId;
    private UUID ticketId;
    private UUID userId;
}
