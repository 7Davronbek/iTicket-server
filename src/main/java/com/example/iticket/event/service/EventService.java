package com.example.iticket.event.service;

import com.example.iticket.custom.CustomHooks;
import com.example.iticket.event.dto.EventCreateDto;
import com.example.iticket.event.dto.EventDtoMapper;
import com.example.iticket.event.dto.EventResponseDto;
import com.example.iticket.event.dto.EventUpdateDto;
import com.example.iticket.event.entity.Event;
import com.example.iticket.event.repository.EventRepository;
import com.example.iticket.hall.entity.Hall;
import com.example.iticket.hall.repository.HallRepository;
import com.example.iticket.user.entity.User;
import com.example.iticket.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDtoMapper eventDtoMapper;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final HallRepository hallRepository;
    private final CustomHooks customHooks;

    public EventResponseDto getEvent(UUID uuid) {
        Optional<Event> optionalEvent = eventRepository.findById(uuid);

        return optionalEvent.map(eventDtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("Event not found"));
    }

    public List<EventResponseDto> getEvents() {
        return eventDtoMapper.toResponse(eventRepository.findAll());
    }

    public void update(UUID uuid, EventUpdateDto eventUpdateDto, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        Optional<Event> optionalEvent = eventRepository.findById(uuid);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();

            if (!event.getName().equals(eventUpdateDto.getName())) {
                Optional<Boolean> eventContains = eventRepository
                        .findAll()
                        .stream()
                        .map(singleEvent -> singleEvent.getName().equals(eventUpdateDto.getName()))
                        .findFirst();

                if (eventContains.isPresent()) throw new NoSuchElementException("Event is already exist");
            }

            eventDtoMapper.toEntity(eventUpdateDto, event);

            eventRepository.save(event);
        } else throw new NoSuchElementException("Event not found");
    }

    public void delete(UUID uuid, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        eventRepository.deleteById(uuid);
    }

    public void create(EventCreateDto eventCreateDto, UUID ownerId, UUID hallId) {
        customHooks.isAdmin(ownerId);

        Optional<Boolean> eventContains = eventRepository
                .findAll()
                .stream()
                .map(event -> event.getName().equals(eventCreateDto.getName()))
                .findFirst();

        if (eventContains.isPresent() && eventContains.get())
            throw new NoSuchElementException("Event is already exist");

        Event event = eventDtoMapper.toEntity(eventCreateDto);
        Optional<User> optionalUser = userRepository.findById(ownerId);
        Optional<Hall> optionalHall = hallRepository.findById(hallId);

        if (optionalHall.isPresent() && optionalUser.isPresent()) {

            User user = optionalUser.get();
            Hall hall = optionalHall.get();

            event.setId(UUID.randomUUID());
            event.setOrganizerID(user.getId());
            event.setHallID(hall.getId());

            eventRepository.save(event);
        } else throw new NoSuchElementException("Not found");
    }
}
