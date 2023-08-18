package models;

import java.util.List;

public class Floor extends BaseClass {
    private Long floorNumber;
    private List<ParkingSpot> parkingSpotList;
    private ParkingLot parkingLot;


    public Long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", parkingSpotList=" + parkingSpotList +
                ", parkingLot=" + parkingLot +
                '}';
    }
}
