package controller;

import dto.TicketRequestDto;
import dto.TicketResponseDto;
import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import models.Ticket;
import service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public TicketResponseDto generateTicket(TicketRequestDto ticketRequestDto) throws NoGateFoundException, NoParkingLotFoundException {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        Ticket ticket = new Ticket();
        try {
            ticket = ticketService.generateTicket(ticketRequestDto.getVechileType(), ticketRequestDto.getVechileNumber(), ticketRequestDto.getVechileOwnerName(), ticketRequestDto.getGateId());
        } catch (Exception e) {
            ticketResponseDto.setTicket(new Ticket());
            ticketResponseDto.setResponseStatus(400);
            ticketResponseDto.setMessage("Bad Request");
            return ticketResponseDto;
        }
        ticketResponseDto.setMessage("SUCCESS");
        ticketResponseDto.setResponseStatus(200);
        ticketResponseDto.setTicket(ticket);
        return ticketResponseDto;
    }
}
