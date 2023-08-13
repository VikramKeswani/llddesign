package com.example.bookmyshow;

import com.example.bookmyshow.controller.TicketController;
import com.example.bookmyshow.dto.BookingRequestDto;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.model.enums.Features;
import com.example.bookmyshow.model.enums.Status;
import com.example.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	ShowSeatRepository showSeatRepository;

	@Autowired
	ShowRepository showRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ShowSeatTypeRepository showSeatTypeRepository;

	@Autowired
	SeatTypeRepository seatTypeRepository;

	@Autowired
	TicketController ticketController;

	@Autowired
	SeatRepository seatRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Bob");
		user.setCreateAt(new Date());
		user.setUpdatedAt(new Date());
		user.setEmail("bobthebuilder@gmail.com");
		user.setPassword("building application");
		User user1 = userRepository.save(user);
		Show show = new Show();
		Show show1 = showRepository.save(show);
		for(int i=0;i<10;i++) {
			ShowSeat showSeat = new ShowSeat();
			showSeat.setShow(show1);
			showSeat.setStatus(Status.AVAILABLE);
			Seat seat = new Seat();
			seat.setSeatType(seatTypeRepository.getReferenceById(1L));
			Seat seatObject = seatRepository.save(seat);
			showSeat.setSeat(seatObject);
			showSeatRepository.save(showSeat);
		}
		ShowSeatType showSeatType = new ShowSeatType();
		showSeatType.setShow(show1);
		SeatType seatType = new SeatType();
		seatType.setName("Maharaja");
		SeatType seatTypeObject = seatTypeRepository.save(seatType);
		showSeatType.setSeatType(seatTypeObject);
		showSeatType.setAmount(5000);
		showSeatTypeRepository.save(showSeatType);

		ShowSeatType showSeatType2 = new ShowSeatType();
		showSeatType2.setShow(show1);
		SeatType seatType2 = new SeatType();
		seatType2.setName("Gold");
		SeatType seatTypeObject2 = seatTypeRepository.save(seatType);
		showSeatType2.setSeatType(seatTypeObject2);
		showSeatType2.setAmount(1000);
		showSeatTypeRepository.save(showSeatType2);

		ShowSeatType showSeatType3 = new ShowSeatType();
		showSeatType3.setShow(show1);
		SeatType seatType3 = new SeatType();
		seatType3.setName("Maharaja");
		SeatType seatTypeObject3 = seatTypeRepository.save(seatType3);
		showSeatType3.setSeatType(seatTypeObject3);
		showSeatType3.setAmount(500);
		showSeatTypeRepository.save(showSeatType3);
		BookingRequestDto bookingRequestDto = new BookingRequestDto();
		bookingRequestDto.setShowId(1L);
		bookingRequestDto.setUserId(1L);
		bookingRequestDto.setShowSeats(List.of(1L,2L,3l,4l,5l,6l,7l));
		ticketController.bookTicketForUser(bookingRequestDto);
    }
}
