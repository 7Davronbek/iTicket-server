package com.example.iticket.user.dto;

import com.example.iticket.user.entity.UserType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    private String surname;
    @NotNull
    @NotBlank
    private String phoneNumber;
    private UserType userType;
}
