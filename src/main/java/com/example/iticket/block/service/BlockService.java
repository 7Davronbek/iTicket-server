package com.example.iticket.block.service;

import com.example.iticket.block.dto.BlockCreateDto;
import com.example.iticket.block.dto.BlockDtoMapper;
import com.example.iticket.block.dto.BlockResponseDto;
import com.example.iticket.block.dto.BlockUpdateDto;
import com.example.iticket.block.enttity.Block;
import com.example.iticket.block.repository.BlockRepository;
import com.example.iticket.custom.CustomHooks;
import com.example.iticket.hall.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockService {
    private final BlockRepository blockRepository;
    private final HallRepository hallRepository;
    private final BlockDtoMapper blockDtoMapper;
    private final CustomHooks customHooks;

    public BlockResponseDto getBlock(UUID uuid) {
        Optional<Block> optionalBlock = blockRepository.findById(uuid);

        return optionalBlock.map(blockDtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("Block not found"));
    }

    public List<BlockResponseDto> getBlocks() {
        return blockDtoMapper.toResponse(blockRepository.findAll());
    }

    public void update(UUID uuid, BlockUpdateDto blockUpdateDto, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        Optional<Block> optionalBlock = blockRepository.findById(uuid);
        if (optionalBlock.isPresent()) {
            Block block = optionalBlock.get();

            blockDtoMapper.toEntity(blockUpdateDto, block);

            blockRepository.save(block);
        } else throw new NoSuchElementException("Block not found");
    }

    public void delete(UUID uuid, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        blockRepository.deleteById(uuid);
    }

    public void create(BlockCreateDto blockCreateDto, UUID ownerId, UUID hallId) {
        customHooks.isAdmin(ownerId);

        Optional<Boolean> blockContains = blockRepository
                .findAll()
                .stream()
                .map(block -> block.getName().equals(blockCreateDto.getName()))
                .findFirst();

        if (blockContains.isPresent() && blockContains.get()) throw new NoSuchElementException("Block is already exist");

        Block block = blockDtoMapper.toEntity(blockCreateDto);
        block.setId(UUID.randomUUID());
        block.setHallId(hallId);

        blockRepository.save(block);
    }
}
