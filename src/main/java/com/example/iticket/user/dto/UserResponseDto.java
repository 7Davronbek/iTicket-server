package com.example.iticket.user.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto extends UserBaseDto {
    private UUID id;
}
