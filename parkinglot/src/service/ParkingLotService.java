package service;

import dto.ParkingLotRegisterResponseDto;
import models.Floor;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.*;
import repositeries.GateRepository;
import repositeries.ParkingLotRepository;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;
    GateService gateService;
    CommonUtil commonUtil;
    FloorService floorService;


    public ParkingLotService(ParkingLotRepository parkingLotRepository, GateService gateService, FloorService floorService) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateService = gateService;
        commonUtil = CommonUtil.getInstance();
        this.floorService = floorService;
    }

    public ParkingLot registerParkingLot(Integer numberOfFloors, Integer numberOfEntryGates, Integer numberOfExitGates, List<VechileType> allowedVehicleType) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setNumber(commonUtil.getParkingLotNumber());
        parkingLot.setSpotFindingStrategyType(SpotFindingStrategyType.SEQUENTIAL);
        parkingLot.setFloor(floorService.floorLinkToParkingLot(parkingLot, numberOfFloors, allowedVehicleType));
        parkingLot.setGate(gateService.registerGateForParkingLot(parkingLot,numberOfEntryGates,numberOfExitGates));
        parkingLot.setVehicleTypes(allowedVehicleType);
        return parkingLotRepository.saveParkingLotInfo(parkingLot);
    }
}
