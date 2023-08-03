package service;

import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VechileType;
import repositeries.ParkingSpotRepository;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotService {

    CommonUtil commonUtil;
    ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(CommonUtil commonUtil, ParkingSpotRepository parkingSpotRepository) {
        this.commonUtil = commonUtil;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> createParkingSpotsForFloor(List<VechileType> allowedVehicleType, Long floorId, Long parkingSpotId) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int j = 0; j < 30; j++) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
            parkingSpot.setSpotNumber(Long.valueOf(j));
            parkingSpot.setId(commonUtil.generateRandomNumber());
            parkingSpot.setVechileType(CommonUtil.getRandomFromListEnum(allowedVehicleType));
            parkingSpot.setFloorId(floorId);
            parkingSpot.setParkingLotId(parkingSpotId);
            parkingSpotRepository.save(parkingSpot);
            parkingSpots.add(parkingSpot);
        }
        return parkingSpots;
    }
}
