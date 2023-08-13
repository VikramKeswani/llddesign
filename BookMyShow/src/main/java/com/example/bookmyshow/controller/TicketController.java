package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.BookingRequestDto;
import com.example.bookmyshow.dto.BookingResponseDto;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

//    @Autowired
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookingResponseDto bookTicketForUser(BookingRequestDto bookingRequestDto) {
        Booking booking = ticketService.bookTicketService(bookingRequestDto.getUserId(), bookingRequestDto.getShowId(), bookingRequestDto.getShowSeats());
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setBookingId(booking.getId());
        bookingResponseDto.setAmount(booking.getAmount());
        return bookingResponseDto;
    }
}
