package com.example.bookmyshow.service;

import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import com.example.bookmyshow.model.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketPriceCalculator {


    @Autowired
    ShowSeatTypeRepository showSeatTypeRepository;
    public int calculateTicketPrice(List<ShowSeat> showSeats, Show show){

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for(ShowSeat showSeat:showSeats){
            for(ShowSeatType showSeatTypeList:showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatTypeList.getSeatType())){
                        amount+=showSeatTypeList.getAmount();
                        break;
                }
            }
        }
        return amount;
    }
}
