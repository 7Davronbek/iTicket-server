package com.example.iticket.hall.controller;

import com.example.iticket.hall.dto.HallCreateDto;
import com.example.iticket.hall.dto.HallResponseDto;
import com.example.iticket.hall.dto.HallUpdateDto;
import com.example.iticket.hall.service.HallService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hall")
public class HallController {
    private final HallService hallService;

    @PostMapping("/ownerId/{ownerId}")
    public void createHall(@Valid @RequestBody HallCreateDto hallCreateDto,
                           @PathVariable("ownerId") UUID ownerId) {
        hallService.create(hallCreateDto, ownerId);
    }

    @GetMapping
    public List<HallResponseDto> getUsers() {
        return hallService.getHalls();
    }

    @GetMapping("/{id}")
    public HallResponseDto getUser(@PathVariable("id") UUID id) {
        return hallService.getHall(id);
    }

    @PutMapping("/{id}/ownerId/{ownerId}")
    public void updateUser(@PathVariable("id") UUID id,
                           @RequestBody HallUpdateDto hallUpdateDto,
                           @PathVariable("ownerId") UUID ownerId) {
        hallService.update(id, hallUpdateDto, ownerId);
    }

    @DeleteMapping("/{id}/ownerId/{ownerId}")
    public void deleteUser(@PathVariable("id") UUID id,
                           @PathVariable("ownerId") UUID ownerid) {
        hallService.delete(id, ownerid);
    }
}
