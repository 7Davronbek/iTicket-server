package com.example.iticket.user.repository;

import com.example.iticket.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface UserRepository extends JpaRepository<User, UUID> {
}
