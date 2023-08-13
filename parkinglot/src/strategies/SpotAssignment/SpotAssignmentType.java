package strategies.SpotAssignment;

import models.Floor;
import models.ParkingSpot;
import models.enums.VechileType;

import java.util.List;

public interface SpotAssignmentType {
    public ParkingSpot getSpot(VechileType vechileType, List<Floor> floors);
}
