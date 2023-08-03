package service;

import models.Floor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VechileType;
import repositeries.FloorRepository;
import repositeries.ParkingSpotRepository;
import utilities.CommonUtil;

import java.util.*;

public class FloorService {
    CommonUtil commonUtil;
    ParkingSpotService parkingSpotService;

    FloorRepository floorRepository;

    public FloorService(CommonUtil commonUtil, ParkingSpotService parkingSpotService, FloorRepository floorRepository) {
        this.commonUtil = commonUtil;
        this.parkingSpotService = parkingSpotService;
        this.floorRepository = floorRepository;
    }

    public List<Floor> floorLinkToParkingLot(ParkingLot parkingLot, int numberOfFloors, List<VechileType> allowedVehicleType) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor();
            floor.setFloorNumber(Long.valueOf(i));
            floor.setId(commonUtil.generateRandomNumber());
            floor.setParkingLot(parkingLot);
            floor.setParkingSpotList(parkingSpotService.createParkingSpotsForFloor(allowedVehicleType, floor.getFloorNumber(), floor.getParkingLot().getNumber()));
           floors.add(floorRepository.saveFloorForParkingLot(floor));
        }
        return floors;
    }
}
