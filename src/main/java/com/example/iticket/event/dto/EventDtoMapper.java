package com.example.iticket.event.dto;

import com.example.iticket.event.entity.Event;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDtoMapper {
    private final ModelMapper mapper = new ModelMapper();

    public EventResponseDto toResponse(Event event) {
        return mapper.map(event, EventResponseDto.class);
    }

    public List<EventResponseDto> toResponse(List<Event> events) {
        return events
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(EventUpdateDto eventUpdateDto, Event event) {
        mapper.map(eventUpdateDto, event);
    }

    public Event toEntity(EventCreateDto eventCreateDto) {
        return mapper.map(eventCreateDto, Event.class);
    }
}
