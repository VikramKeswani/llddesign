package com.example.bookmyshow.service;

import com.example.bookmyshow.exception.ShowNotFoundException;
import com.example.bookmyshow.exception.UserNotFound;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.model.enums.BookingStatus;
import com.example.bookmyshow.model.enums.Status;
import com.example.bookmyshow.repositories.BookingRepository;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    UserRepository userRepository;

    ShowRepository showRepository;

    ShowSeatRepository showSeatRepository;

    BookingRepository bookingRepository;

    TicketPriceCalculator ticketPriceCalculator;

    @Autowired
    public TicketService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository,BookingRepository bookingRepository,TicketPriceCalculator ticketPriceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.ticketPriceCalculator = ticketPriceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicketService(Long userId, Long showId, List<Long> showSeats) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new UserNotFound();
        }

        User userBooking = user.get();

        // User Authentication We will do


        //Show Check
        Optional<Show> show = showRepository.findById(showId);

        if (show.isEmpty()) {
            throw new ShowNotFoundException("Show Not Found With Given Id");
        }

        Show bookShow = show.get();
        List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeats);
//        System.out.println("Show Seat List:");
//        System.out.println(showSeatList);

        for (ShowSeat showSeat : showSeatList) {
            if(showSeat.getStatus().equals(Status.BLOCKED) && Duration.between(showSeat.getBlockedAt().toInstant(),new Date().toInstant()).toMinutes()<15){
                throw new RuntimeException();
            }

        }

        List<ShowSeat> savedShowSeat = new ArrayList<>();
        for(ShowSeat showSeat:showSeatList){
            System.out.println("Inside the code");
            showSeat.setStatus(Status.BLOCKED);
            savedShowSeat.add(showSeat);
            showSeatRepository.save(showSeat);
        }
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setShowSeats(savedShowSeat);
        booking.setShow(bookShow);
        booking.setUser(userBooking);
        booking.setPaymentList(new ArrayList<>());
        booking.setCreateAt(new Date());
        booking.setUpdatedAt(new Date());
        booking.setAmount(ticketPriceCalculator.calculateTicketPrice(savedShowSeat,bookShow));
        bookingRepository.save(booking);
        return booking;
    }
}
