package models;

import models.enums.ParkingSpotStatus;
import models.enums.VechileType;

public class ParkingSpot extends BaseClass {
    private Long spotNumber;
    VechileType vechileType;
    Long floorId;
    ParkingSpotStatus parkingSpotStatus;
    Long parkingLotId;

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Long getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Long spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
