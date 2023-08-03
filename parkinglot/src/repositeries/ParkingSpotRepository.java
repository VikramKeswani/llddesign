package repositeries;

import models.ParkingSpot;
import utilities.CommonUtil;

import java.util.*;

public class ParkingSpotRepository {
    CommonUtil commonUtil;

    Map<String, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot save(ParkingSpot parkingSpot) {
        String key = commonUtil.generateParkingSpotKey(parkingSpot.getParkingLotId(), parkingSpot.getFloorId(), parkingSpot.getSpotNumber());
        parkingSpot.setCreatedAt(new Date());
        parkingSpot.setUpdatedAt(new Date());
        parkingSpotMap.put(key, parkingSpot);
        return parkingSpot;
    }

}
