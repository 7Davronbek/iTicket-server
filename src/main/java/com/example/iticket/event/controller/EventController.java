package com.example.iticket.event.controller;

import com.example.iticket.event.dto.EventCreateDto;
import com.example.iticket.event.dto.EventResponseDto;
import com.example.iticket.event.dto.EventUpdateDto;
import com.example.iticket.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public void createEvent(@Valid @RequestBody EventCreateDto eventCreateDto,
                            @RequestHeader(name = "ownerId") UUID ownerId,
                            @RequestHeader(name = "hallId") UUID hallId) {
        eventService.create(eventCreateDto, ownerId, hallId);
    }

    @GetMapping
    public List<EventResponseDto> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public EventResponseDto getEvent(@PathVariable("id") UUID id) {
        return eventService.getEvent(id);
    }

    @PutMapping("/{id}")
    public void updateEvent(@PathVariable("id") UUID id,
                            @RequestBody EventUpdateDto eventUpdateDto,
                            @RequestHeader(name = "ownerId") UUID ownerId) {
        eventService.update(id, eventUpdateDto, ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") UUID id,
                            @RequestHeader(name = "ownerId") UUID ownerId) {
        eventService.delete(id, ownerId);
    }
}
