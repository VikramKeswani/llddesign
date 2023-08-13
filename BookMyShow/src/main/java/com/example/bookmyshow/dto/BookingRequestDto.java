package com.example.bookmyshow.dto;

import com.example.bookmyshow.model.ShowSeat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookingRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeats;
}
