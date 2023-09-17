package com.example.iticket.ticket.controller;

import com.example.iticket.ticket.dto.TicketCreateDto;
import com.example.iticket.ticket.dto.TicketResponseDto;
import com.example.iticket.ticket.dto.TicketUpdateDto;
import com.example.iticket.ticket.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("")
    public void createTicket(@Valid @RequestBody TicketCreateDto ticketCreateDto,
                             @RequestHeader(value = "ownerId") UUID ownerId,
                             @RequestHeader(value = "eventId") UUID eventId,
                             @RequestHeader(value = "blockId") UUID blockId) {
        ticketService.create(ticketCreateDto, ownerId, eventId, blockId);
    }

    @GetMapping
    public List<TicketResponseDto> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/{id}")
    public TicketResponseDto getTicket(@PathVariable("id") UUID id) {
        return ticketService.getTicket(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") UUID id,
                           @RequestBody TicketUpdateDto ticketUpdateDto,
                           @RequestHeader(value = "ownerId") UUID ownerId) {
        ticketService.update(id, ticketUpdateDto, ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") UUID id,
                           @RequestHeader(value = "ownerId") UUID ownerId) {
        ticketService.delete(id, ownerId);
    }
}
