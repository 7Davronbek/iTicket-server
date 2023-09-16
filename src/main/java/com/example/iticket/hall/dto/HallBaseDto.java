package com.example.iticket.hall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallBaseDto {
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String country;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String region;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String city;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String buildingName;
    private int capacity;
}
