package com.example.iticket.user.dto;

import com.example.iticket.user.entity.UserType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private UserType userType;
}
