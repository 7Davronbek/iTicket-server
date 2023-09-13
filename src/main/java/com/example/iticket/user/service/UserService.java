package com.example.iticket.user.service;

import com.example.iticket.common.CommonService;
import com.example.iticket.user.dto.UserResponseDto;
import com.example.iticket.user.dto.UserUpdateDto;
import com.example.iticket.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements CommonService<UUID, UserResponseDto, UserUpdateDto> {

    private final LinkedHashMap<UUID, User> users = new LinkedHashMap<>();


    @Override
    public UserResponseDto findById(UUID uuid) {
        User user = users.get(uuid);
        if(user == null) return null;

        return null;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return null;
    }

    @Override
    public UserResponseDto update(UUID uuid, UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public UserResponseDto add(UserResponseDto userResponseDto) {
        return null;
    }
}
