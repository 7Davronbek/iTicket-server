package com.example.iticket.event.dto;

import lombok.*;

import java.util.UUID;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDto extends EventBaseDto {
    private UUID id;
    private UUID hallID;
    private UUID organizerID;
}
