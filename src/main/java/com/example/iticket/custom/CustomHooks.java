package com.example.iticket.custom;

import com.example.iticket.user.entity.User;
import com.example.iticket.user.entity.UserType;
import com.example.iticket.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
@Component
@RequiredArgsConstructor
public class CustomHooks {
    private final UserRepository userRepository;
    public void isAdmin(UUID ownerId) {
        Optional<User> optionalUser = userRepository.findById(ownerId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            boolean isAdmin = user.getUserType().equals(UserType.ADMIN);
            if(!isAdmin) throw new IllegalArgumentException("Not allowed");
        } else throw new NoSuchElementException("User not found");
    }
}
