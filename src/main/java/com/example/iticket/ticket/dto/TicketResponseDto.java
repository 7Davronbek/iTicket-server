package com.example.iticket.ticket.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class TicketResponseDto extends TicketBaseDto{
    private UUID id;
    private UUID blockId;
    private UUID eventId;
}
