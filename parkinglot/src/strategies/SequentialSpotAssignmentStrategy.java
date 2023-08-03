package strategies;

import models.Floor;
import models.ParkingSpot;
import models.enums.ParkingSpotStatus;
import models.enums.VechileType;

import java.util.List;

public class SequentialSpotAssignmentStrategy implements SpotAssignmentType{
    @Override
    public ParkingSpot getSpot(VechileType vechileType,List<Floor> floors) {
        for(Floor floor:floors){
            for(ParkingSpot parkingSpot:floor.getParkingSpotList()){
                if(parkingSpot.getVechileType().equals(vechileType) && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY))
                        return parkingSpot;
            }
        }
        return null;
    }
}
