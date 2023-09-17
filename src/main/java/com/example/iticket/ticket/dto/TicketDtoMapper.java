package com.example.iticket.ticket.dto;


import com.example.iticket.ticket.entity.Ticket;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDtoMapper {
    private final ModelMapper mapper = new ModelMapper();

    public TicketResponseDto toResponse(Ticket ticket) {
        return mapper.map(ticket, TicketResponseDto.class);
    }

    public List<TicketResponseDto> toResponse(List<Ticket> tickets) {
        return tickets
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(TicketUpdateDto ticketUpdateDto, Ticket ticket) {
        mapper.map(ticketUpdateDto, ticket);
    }

    public Ticket toEntity(TicketCreateDto ticketCreateDto) {
        return mapper.map(ticketCreateDto, Ticket.class);
    }
}
