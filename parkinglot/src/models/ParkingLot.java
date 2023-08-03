package models;

import models.enums.FeesCalculationStrategyType;
import models.enums.ParkingLotStatus;
import models.enums.SpotFindingStrategyType;
import models.enums.VechileType;

import java.util.List;

public class ParkingLot extends BaseClass {

    private Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    private List<Gate> gates;

    private List<Floor> floor;

    private List<VechileType> vehicleTypes;

    private FeesCalculationStrategyType feesCalculationStrategyType;

    private SpotFindingStrategyType spotFindingStrategyType;

    private ParkingLotStatus parkingLotStatus;


    public List<Gate> getGate() {
        return gates;
    }

    public void setGate(List<Gate> gates) {
        this.gates = gates;
    }

    public List<Floor> getFloor() {
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VechileType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VechileType> vehicleTypes) {
        this. vehicleTypes = vehicleTypes;
    }

    public FeesCalculationStrategyType getFeesCalculationStrategyType() {
        return feesCalculationStrategyType;
    }

    public void setFeesCalculationStrategyType(FeesCalculationStrategyType feesCalculationStrategyType) {
        this.feesCalculationStrategyType = feesCalculationStrategyType;
    }

    public SpotFindingStrategyType getSpotFindingStrategyType() {
        return spotFindingStrategyType;
    }

    public void setSpotFindingStrategyType(SpotFindingStrategyType spotFindingStrategyType) {
        this.spotFindingStrategyType = spotFindingStrategyType;
    }
}
