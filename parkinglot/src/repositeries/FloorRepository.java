package repositeries;

import models.Floor;
import utilities.CommonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FloorRepository {

    Map<String, Floor> floorMap;

    CommonUtil commonUtil;

    public FloorRepository(CommonUtil commonUtil) {
        this.floorMap = new HashMap<>();
        this.commonUtil = commonUtil;
    }

    public Floor saveFloorForParkingLot(Floor floor) {
        String key = commonUtil.generateFloorKey(floor.getParkingLot().getNumber(), floor.getFloorNumber());
        floor.setCreatedAt(new Date());
        floor.setUpdatedAt(new Date());
        floorMap.put(key, floor);
        return floor;
    }
}
