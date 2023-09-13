package com.example.iticket.user.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDto extends UserBaseDto {
    private String password;
}
