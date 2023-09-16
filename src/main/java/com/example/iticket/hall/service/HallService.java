package com.example.iticket.hall.service;

//import com.example.iticket.event.repository.UserRepository;
import com.example.iticket.custom.CustomHooks;
import com.example.iticket.hall.dto.HallCreateDto;
import com.example.iticket.hall.dto.HallDtoMapper;
import com.example.iticket.hall.dto.HallResponseDto;
import com.example.iticket.hall.dto.HallUpdateDto;
import com.example.iticket.hall.entity.Hall;
import com.example.iticket.hall.repository.HallRepository;
import com.example.iticket.user.entity.User;
import com.example.iticket.user.entity.UserType;
import com.example.iticket.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallDtoMapper hallDtoMapper;
    private final HallRepository hallRepository;
    private final CustomHooks customHooks;

    public HallResponseDto getHall(UUID uuid) {
        Optional<Hall> optionalHall = hallRepository.findById(uuid);

        return optionalHall.map(hallDtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("Hall not found"));
    }

    public List<HallResponseDto> getHalls() {
        return hallDtoMapper.toResponse(hallRepository.findAll());
    }

    public void update(UUID uuid, HallUpdateDto hallUpdateDto, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        Optional<Hall> optionalHall = hallRepository.findById(uuid);
        if (optionalHall.isPresent()) {
            Hall hall = optionalHall.get();

            hallDtoMapper.toEntity(hallUpdateDto, hall);

            hallRepository.save(hall);
            return;
        }
        throw new NoSuchElementException("Hall not found");
    }

    public void delete(UUID uuid, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        hallRepository.deleteById(uuid);
    }

    public void create(HallCreateDto hallCreateDto, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        Optional<Boolean> hallContains = hallRepository
                .findAll()
                .stream()
                .map(hall -> hall.getBuildingName().equals(hallCreateDto.getBuildingName()))
                .findFirst();

        if (hallContains.isPresent() && hallContains.get()) throw new NoSuchElementException("Hall is already exist");

        Hall hall = hallDtoMapper.toEntity(hallCreateDto);
        hall.setId(UUID.randomUUID());
        hall.setOwnerId(ownerId);

        hallRepository.save(hall);
    }
}
