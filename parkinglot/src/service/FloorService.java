package service;

import models.Floor;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VechileType;
import repositeries.ParkingSpotRepository;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FloorService {

    CommonUtil commonUtil;

    ParkingSpotRepository parkingSpotRepository;

    public FloorService(CommonUtil commonUtil,ParkingSpotRepository parkingSpotRepository){
        this.commonUtil = commonUtil;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<Floor> floorLinkToParkingLot(Long parkingLotNumber, int numberOfFloors, List<VechileType> allowedVehicleType) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor();
            floor.setFloorNumber(Long.valueOf(i));
            floor.setId(commonUtil.generateRandomNumber());
            floor.setParkingLotId(parkingLotNumber);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for (int j = 0; j < 30; j++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setSpotNumber(j);
                parkingSpot.setId(commonUtil.generateRandomNumber());
                parkingSpot.setVechileType(CommonUtil.getRandomFromListEnum(allowedVehicleType));
                parkingSpot.setFloor(floor);
                parkingSpot.setCreatedAt(new Date());
                parkingSpot.setUpdatedAt(new Date());
                parkingSpots.add(parkingSpot);
            }
            floor.setParkingSpotList(parkingSpots);
        }
        return floors;
    }
}
