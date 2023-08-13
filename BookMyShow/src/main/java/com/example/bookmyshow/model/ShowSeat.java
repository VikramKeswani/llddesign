package com.example.bookmyshow.model;

import com.example.bookmyshow.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@ToString
public class ShowSeat extends BaseModel {
    @ManyToOne
    Show show;

    @ManyToOne
    Seat seat;

    @Enumerated(EnumType.ORDINAL)
    Status status;

    @ManyToOne
    Booking booking;

    Date blockedAt;
}
