package com.example.iticket.block.dto;

import com.example.iticket.block.enttity.Block;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockDtoMapper {
    private final ModelMapper mapper = new ModelMapper();

    public BlockResponseDto toResponse(Block block) {
        return mapper.map(block, BlockResponseDto.class);
    }

    public List<BlockResponseDto> toResponse(List<Block> blocks) {
        return blocks
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(BlockUpdateDto blockUpdateDto, Block block) {
        mapper.map(blockUpdateDto, block);
    }

    public Block toEntity(BlockCreateDto blockCreateDto) {
        return mapper.map(blockCreateDto, Block.class);
    }
}
