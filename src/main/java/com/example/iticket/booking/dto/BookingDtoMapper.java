package com.example.iticket.booking.dto;

import com.example.iticket.booking.entity.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDtoMapper {
    private final ModelMapper mapper = new ModelMapper();

    public BookingResponseDto toResponse(Booking booking)
    {
        return mapper.map(booking, BookingResponseDto.class);
    }

    public List<BookingResponseDto> toResponse(List<Booking> bookings) {
        return bookings
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void toEntity(BookingUpdateDto bookingUpdateDto, Booking booking)
    {
        mapper.map(bookingUpdateDto, booking);
    }

    public Booking toEntity(BookingCreateDto bookingCreateDto)
    {
        return mapper.map(bookingCreateDto, Booking.class);
    }
}

