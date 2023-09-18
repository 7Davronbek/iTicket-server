package com.example.iticket.booking.controller;

import com.example.iticket.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;

    @PostMapping
    public void createBooking(@RequestHeader(name = "ownerId")UUID userId,
                              @RequestHeader(name = "ticketId") UUID tickedId) {
        service.create(userId,tickedId);
    }

//    //    @GetMapping("/ownerId/{ownerId}")
//    @GetMapping
//    public List<UserResponseDto> getUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{id}")
//    public UserResponseDto getUser(@PathVariable("id") UUID id) {
//        return userService.getUser(id);
//    }
//
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable("id") UUID id, @RequestBody UserUpdateDto userUpdateDTO) {
//        userService.update(id, userUpdateDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable("id") UUID id) {
//        userService.delete(id);
//    }
}
