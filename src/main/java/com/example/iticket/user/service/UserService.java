package com.example.iticket.user.service;

import com.example.iticket.user.dto.UserCreateDto;
import com.example.iticket.user.dto.UserDtoMapper;
import com.example.iticket.user.dto.UserResponseDto;
import com.example.iticket.user.dto.UserUpdateDto;
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
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserResponseDto getUser(UUID uuid) {
        Optional<User> optionalUser = userRepository.findById(uuid);

        return optionalUser.map(userDtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public List<UserResponseDto> getUsers() {
//        customHooks.isAdmin(ownerId);

        return userDtoMapper.toResponse(userRepository.findAll());
    }

    public void update(UUID uuid, UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(uuid);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getPhoneNumber().equals(userUpdateDto.getPhoneNumber())) {
                Optional<Boolean> userContains = userRepository
                        .findAll()
                        .stream()
                        .map(sungleUser -> sungleUser.getPhoneNumber().equals(userUpdateDto.getPhoneNumber()))
                        .findFirst();

                if (userContains.isPresent()) throw new NoSuchElementException("User is already exist");
            }

            userDtoMapper.toEntity(userUpdateDto, user);

            userRepository.save(user);
        } else throw new NoSuchElementException("User not found");
    }

    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public void create(UserCreateDto userCreateDto) {
        Optional<Boolean> userContains = userRepository
                .findAll()
                .stream()
                .map(user -> user.getPhoneNumber().equals(userCreateDto.getPhoneNumber()))
                .findFirst();

        if (userContains.isPresent() && userContains.get()) throw new NoSuchElementException("User is already exist");

        User user = userDtoMapper.toEntity(userCreateDto);
        user.setId(UUID.randomUUID());

        userRepository.save(user);
    }
}

