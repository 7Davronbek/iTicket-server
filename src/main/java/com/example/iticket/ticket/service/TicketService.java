package com.example.iticket.ticket.service;

import com.example.iticket.block.enttity.Block;
import com.example.iticket.block.repository.BlockRepository;
import com.example.iticket.custom.CustomHooks;
import com.example.iticket.event.entity.Event;
import com.example.iticket.event.repository.EventRepository;
import com.example.iticket.ticket.dto.TicketCreateDto;
import com.example.iticket.ticket.dto.TicketDtoMapper;
import com.example.iticket.ticket.dto.TicketResponseDto;
import com.example.iticket.ticket.dto.TicketUpdateDto;
import com.example.iticket.ticket.entity.Ticket;
import com.example.iticket.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketDtoMapper ticketDtoMapper;
    private final TicketRepository ticketRepository;
    private final CustomHooks customHooks;
    private final BlockRepository blockRepository;
    private final EventRepository eventRepository;


    public void create(TicketCreateDto ticketCreateDto, UUID ownerId, UUID eventId, UUID blockId) {
        customHooks.isAdmin(ownerId);

        Optional<Boolean> ticketContains = ticketRepository
                .findAll()
                .stream()
                .map(ticket -> ticket.getName().equals(ticketCreateDto.getName()))
                .findFirst();

        if (ticketContains.isPresent() && ticketContains.get())
            throw new NoSuchElementException("Ticket is already exist");

        Optional<Block> optionalBlock = blockRepository.findById(blockId);
        Optional<Event> optionalEvent = eventRepository.findById(eventId);

        if (optionalBlock.isPresent() && optionalEvent.isPresent()) {
            Ticket ticket = ticketDtoMapper.toEntity(ticketCreateDto);

            ticket.setId(UUID.randomUUID());
            ticket.setBlockId(blockId);
            ticket.setEventId(eventId);

            ticketRepository.save(ticket);
        } else throw new NoSuchElementException("Not found");
    }
    public TicketResponseDto getTicket(UUID uuid) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(uuid);

        return optionalTicket.map(ticketDtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("Ticket not found"));
    }

    public List<TicketResponseDto> getTickets() {
        return ticketDtoMapper.toResponse(ticketRepository.findAll());
    }

    public void update(UUID uuid, TicketUpdateDto ticketUpdateDto, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        Optional<Ticket> optionalTicket = ticketRepository.findById(uuid);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            if (!ticket.getName().equals(ticketUpdateDto.getName())) {
                Optional<Boolean> ticketContains = ticketRepository
                        .findAll()
                        .stream()
                        .map(singleTicket -> singleTicket.getName().equals(ticketUpdateDto.getName()))
                        .findFirst();

                if (ticketContains.isPresent() && ticketContains.get())
                    throw new NoSuchElementException("Ticket is already exist");
            }

            ticketDtoMapper.toEntity(ticketUpdateDto, ticket);

            ticketRepository.save(ticket);
        } else throw new NoSuchElementException("Ticket not found");
    }

    public void delete(UUID uuid, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        ticketRepository.deleteById(uuid);
    }
}
