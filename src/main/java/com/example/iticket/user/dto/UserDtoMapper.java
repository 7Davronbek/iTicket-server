package com.example.iticket.user.dto;

import com.example.iticket.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDtoMapper {
    private final ModelMapper mapper = new ModelMapper();

    public UserResponseDto toResponse(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    public List<UserResponseDto> toResponse(List<User> users) {
        return users
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(UserUpdateDto userUpdateDTO, User user) {
        mapper.map(userUpdateDTO, user);
    }

    public User toEntity(UserCreateDto userCreateDTO) {
        return mapper.map(userCreateDTO, User.class);
    }
}
