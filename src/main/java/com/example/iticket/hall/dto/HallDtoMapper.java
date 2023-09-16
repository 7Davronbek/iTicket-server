package com.example.iticket.hall.dto;

import com.example.iticket.hall.entity.Hall;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HallDtoMapper {
    private final ModelMapper mapper = new ModelMapper();


    public HallResponseDto toResponse(Hall hall) {
        return mapper.map(hall, HallResponseDto.class);
    }

    public List<HallResponseDto> toResponse(List<Hall> halls) {
        return halls
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(HallUpdateDto hallUpdateDto, Hall hall) {
        mapper.map(hallUpdateDto, hall);
    }

    public Hall toEntity(HallCreateDto hallCreateDto) {
        return mapper.map(hallCreateDto, Hall.class);
    }
}
