package com.example.iticket.user.controller;

import com.example.iticket.user.dto.UserCreateDto;
import com.example.iticket.user.dto.UserResponseDto;
import com.example.iticket.user.dto.UserUpdateDto;
import com.example.iticket.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @PostMapping
    public void createUser(@Valid @RequestBody UserCreateDto userCreateDTO) {
        userService.create(userCreateDTO);
    }

//    @GetMapping("/ownerId/{ownerId}")
    @GetMapping
    public List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable("id") UUID id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UUID id, @RequestBody UserUpdateDto userUpdateDTO) {
        userService.update(id, userUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") UUID id) {
        userService.delete(id);
    }
}
