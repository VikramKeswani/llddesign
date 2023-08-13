package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Seat extends BaseModel {
    String num;

    @ManyToOne
    SeatType seatType;

    int rowVal;

    int colVal;

}
