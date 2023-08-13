package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    Show show;

    @ManyToOne
    SeatType seatType;

    int amount;
}
