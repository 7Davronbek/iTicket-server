package com.example.iticket.block.enttity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`Block`")
public class Block {
    @Id
    private UUID id;
    private UUID hallId;
    private String name;
    private int countOfSeat;
}
