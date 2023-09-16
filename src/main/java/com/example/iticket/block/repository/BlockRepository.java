package com.example.iticket.block.repository;

import com.example.iticket.block.enttity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlockRepository extends JpaRepository<Block, UUID> {
}
