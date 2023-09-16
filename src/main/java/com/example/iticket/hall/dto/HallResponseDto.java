package com.example.iticket.hall.dto;

import lombok.*;

import java.util.UUID;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallResponseDto extends HallBaseDto{
    private UUID id;
    private UUID ownerId;
}
