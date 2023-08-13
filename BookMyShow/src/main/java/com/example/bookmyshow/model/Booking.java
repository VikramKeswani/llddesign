package com.example.bookmyshow.model;

import com.example.bookmyshow.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel {

    @ManyToOne
    private User user;

    private Date bookingTime;

    @OneToMany
    List<Payment> paymentList;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private Show show;
}
