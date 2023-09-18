package com.example.iticket.booking.service;

import com.example.iticket.block.enttity.Block;
import com.example.iticket.block.repository.BlockRepository;
import com.example.iticket.custom.CustomHooks;
import com.example.iticket.ticket.entity.Ticket;
import com.example.iticket.ticket.repository.TicketRepository;
import com.example.iticket.user.entity.User;
import com.example.iticket.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BlockRepository blockRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CustomHooks customHooks;

//    public BookingResponseDto getBooking(UUID bookingId) {
//        Optional<Booking> optionalBooking = repository.findById(bookingId);
//        Booking booking = optionalBooking.get();
//        booking.setBookId(bookingId);
//        booking.set
//        return optionalBooking.map(dtoMapper::toResponse).orElseThrow(() -> new NoSuchElementException("Booking not found"));
//    }
//
//    public List<BookingResponseDto> getBookings() {
//
//        return dtoMapper.toResponse(repository.findAll());
//    }

    public void delete(UUID uuid, UUID ownerId) {
        customHooks.isAdmin(ownerId);

        ticketRepository.deleteById(uuid);
    }

    public void create(UUID userId, UUID tickedId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(tickedId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            Optional<Block> optionalBlock = blockRepository.findById(ticket.getBlockId());
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalBlock.isPresent() && optionalUser.isPresent()) {
                Block block = optionalBlock.get();
                User user = optionalUser.get();
                if (block.getCountOfSeat() <= 0) {
                    throw new NoSuchElementException("No tickets left");
                } else {
                    block.setCountOfSeat(block.getCountOfSeat() - 1);
                    blockRepository.save(block);
                }
            } else throw new NoSuchElementException("User or ticket not found");
        }
    }
}
