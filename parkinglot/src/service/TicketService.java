package service;

import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import models.*;
import models.enums.VechileType;
import repositeries.GateRepository;
import repositeries.ParkingLotRepository;
import repositeries.TicketRepository;
import repositeries.VehicleRepository;
import models.enums.SpotFindingStrategyType;
import strategies.SpotAssignment.SpotAssignmentStrategyFactory;
import strategies.SpotAssignment.SpotAssignmentType;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    Gate gate;

    GateRepository gateRepository;

    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;

    TicketRepository ticketRepository;


    private static Long ticketNumber;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(VechileType vechileType, String vehicleNumber, String vehicleOwnerName, Long gateId) throws NoGateFoundException, NoParkingLotFoundException {
        Ticket ticket = new Ticket();
        ticketNumber = ticketNumber + 1;
        ticket.setTicketNumber(ticketNumber);
        ticket.setEntryTime(new Date());
        Optional<Gate> gateInfo = gateRepository.getGateInfo(gateId);

        if (gateInfo.isEmpty()) {
            throw new NoGateFoundException("No Gate Found For this gateId");
        }
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        Optional<Vehicle> vehicleInfo = vehicleRepository.getVehicleInfo(vehicleNumber);
        if (vehicleInfo.isPresent()) {
            ticket.setVechile(vehicleInfo.get());
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleOwnerName(vehicleOwnerName);
            vehicle.setVechileType(vechileType);
            Vehicle vehicleObject = vehicleRepository.save(vehicle);
            ticket.setVechile(vehicleObject);
        }
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotInfoByGateId(gate);
        if (parkingLot.isPresent()) {
            SpotFindingStrategyType spotFindingStrategyType = parkingLot.get().getSpotFindingStrategyType();
            SpotAssignmentType spotAssignmentType = SpotAssignmentStrategyFactory.spotAssignmentStrategy(spotFindingStrategyType);
            ParkingSpot parkingSpot = spotAssignmentType.getSpot(vechileType,parkingLot.get().getFloor());
            ticket.setParkingSpot(parkingSpot);
        } else
            throw new NoParkingLotFoundException("No ParkingSpot Found");

        return ticketRepository.save(ticket);
    }
}
