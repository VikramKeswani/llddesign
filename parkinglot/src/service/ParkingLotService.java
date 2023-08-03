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
    GateRepository gateRepository;
    CommonUtil commonUtil;
    FloorService floorService;


    public ParkingLotService(ParkingLotRepository parkingLotRepository, GateRepository gateRepository,FloorService floorService) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        commonUtil = CommonUtil.getInstance();
        this.floorService = floorService;
    }

    public ParkingLot registerParkingLot(Integer numberOfFloors, Integer numberOfEntryGates, Integer numberOfExitGates, List<VechileType> allowedVehicleType) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setNumber(commonUtil.getParkingLotNumber());
        parkingLot.setSpotFindingStrategyType(SpotFindingStrategyType.SEQUENTIAL);
        parkingLot.setFloor(floorService.floorLinkToParkingLot(parkingLot.getNumber(),numberOfFloors,allowedVehicleType));
        List<Gate> gates = new ArrayList<>();
        for(int i=0;i<numberOfEntryGates;i++){
            Gate gate = new Gate();
            gate.setGateNumber(i);
            gate.setGateType(GateType.ENTRY_GATE);
            gate.set
        }
        parkingLot.setCreatedAt(new Date());
        parkingLot.setUpdatedAt(new Date());
        parkingLot.setVehicleTypes(allowedVehicleType);
        return parkingLotRepository.saveParkingLotInfo(parkingLot);
    }
}
