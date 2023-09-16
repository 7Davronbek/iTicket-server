package com.example.iticket.block.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockBaseDto {
    @NotNull
    @NotBlank
    @Size(min = 1)
    private String name;
    private int countOfSeat;
}
