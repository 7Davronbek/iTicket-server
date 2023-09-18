package com.example.iticket.block.controller;


import com.example.iticket.block.dto.BlockCreateDto;
import com.example.iticket.block.dto.BlockResponseDto;
import com.example.iticket.block.dto.BlockUpdateDto;
import com.example.iticket.block.service.BlockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/block")
public class BlockController {
    private final BlockService blockService;

    @PostMapping
    public void createBlock(@Valid @RequestBody BlockCreateDto blockCreateDto,
                            @RequestHeader(name = "ownerId") UUID ownerId,
                            @RequestHeader(name = "hallId") UUID hallId) {
        blockService.create(blockCreateDto, ownerId, hallId);
    }

    @GetMapping
    public List<BlockResponseDto> getBlocks() {
        return blockService.getBlocks();
    }

    @GetMapping("/{id}")
    public BlockResponseDto getBlock(@PathVariable("id") UUID id) {
        return blockService.getBlock(id);
    }

    @PutMapping("/{id}")
    public void updateBlock(@PathVariable("id") UUID id,
                            @RequestBody BlockUpdateDto blockUpdateDto,
                            @RequestHeader(name = "ownerId") UUID ownerId) {
        blockService.update(id, blockUpdateDto, ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteBlock(@PathVariable("id") UUID id,
                            @RequestHeader(name = "ownerId") UUID ownerid) {
        blockService.delete(id, ownerid);
    }
}
