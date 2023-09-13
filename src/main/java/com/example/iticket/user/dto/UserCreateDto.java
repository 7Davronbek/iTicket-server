package com.example.iticket.user.dto;

import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto extends UserBaseDto {
    private String password;
}
