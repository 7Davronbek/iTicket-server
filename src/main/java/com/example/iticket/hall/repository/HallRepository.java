package com.example.iticket.hall.repository;

import com.example.iticket.hall.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {
}
