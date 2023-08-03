import controller.ParkingLotController;
import controller.TicketController;
import models.enums.VechileType;
import repositeries.*;
import service.*;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplication {
    public static void main(String[] args) {
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
    }
}