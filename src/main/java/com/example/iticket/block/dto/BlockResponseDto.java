package com.example.iticket.block.dto;

import lombok.*;

import java.util.UUID;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockResponseDto extends BlockBaseDto{
    private UUID id;
    private UUID hallId;
}
