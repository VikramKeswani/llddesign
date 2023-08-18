import controller.ParkingLotController;
import controller.TicketController;
import dto.TicketRequestDto;
import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import models.*;
import models.enums.*;
import repositeries.*;
import service.*;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLotApplication {
    public static void main(String[] args) throws NoGateFoundException, NoParkingLotFoundException {
        CommonUtil commonUtil = CommonUtil.getInstance();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository(commonUtil);
        FloorRepository floorRepository = new FloorRepository(commonUtil);
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository(commonUtil);
        GateService gateService = new GateService(gateRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(commonUtil, parkingSpotRepository);
        FloorService floorService = new FloorService(commonUtil, parkingSpotService, floorRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository,gateService,floorService);
        List<VechileType> allowedVehicleType = new ArrayList<>();
        allowedVehicleType.add(VechileType.CAR);
        allowedVehicleType.add(VechileType.TRUCK);
        allowedVehicleType.add(VechileType.TWO_WHEELER);
        allowedVehicleType.add(VechileType.THREE_WHEELER);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        //parking lot object.
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setNumber(1L);



        //Gate Object
        Gate gate = new Gate();
        gate.setId(1L);
        gate.setGateType(GateType.ENTRY_GATE);
        gate.setOperator(new Operator());
        gate.setUpdatedAt(new Date());
        gate.setCreatedAt(new Date());
        gate.setGateNumber(1L);
        gateRepository.saveGateInfo(parkingLot,gate, GateType.ENTRY_GATE);

        //Floor Object
        Floor floor = new Floor();
        floor.setParkingLot(parkingLot);
        floor.setFloorNumber(1L);
        floor.setId(1L);
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingLotId(1L);
        parkingSpot.setFloorId(1L);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpot.setVechileType(VechileType.CAR);
        parkingSpot.setId(1L);
        parkingLot.setNumber(1L);
        parkingLot.setGate(List.of(gate));
        floor.setParkingSpotList(List.of(parkingSpot));
        floorRepository.saveFloorForParkingLot(floor);
        parkingLot.setFloor(List.of(floor));
        parkingLot.setSpotFindingStrategyType(SpotFindingStrategyType.SEQUENTIAL);
        parkingLotRepository.saveParkingLotInfo(parkingLot);

        parkingLot.setGate(List.of(gate));
        parkingLotRepository.saveParkingLotInfo(parkingLot);

        //Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleOwnerName("ABC");
        vehicle.setVehicleNumber("MP04 QP1234");
        vehicle.setId(1L);
        vehicle.setVehicleOwnerName("BOSS");
        vehicle.setVechileType(VechileType.CAR);
        vehicleRepository.save(vehicle);



        TicketRequestDto ticketRequestDto = new TicketRequestDto();
        ticketRequestDto.setGateId(1L);
        ticketRequestDto.setVechileType(VechileType.CAR);
        ticketRequestDto.setVechileNumber("MP04 QP1234");
        ticketRequestDto.setVechileOwnerName("BOSS");
        ticketController.generateTicket(ticketRequestDto);

    }
}