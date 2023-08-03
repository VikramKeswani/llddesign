package dto;

import models.Floor;
import models.Gate;
import models.enums.VechileType;

import java.util.List;

public class ParkingLotRegisterRequestDto {
    private Integer floors;
    private List<VechileType> allowedVehicleTypes;
    private Integer entryGates;
    private Integer exitGate;


    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public List<VechileType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VechileType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public Integer getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(Integer entryGates) {
        this.entryGates = entryGates;
    }

    public Integer getExitGate() {
        return exitGate;
    }

    public void setExitGate(Integer exitGate) {
        this.exitGate = exitGate;
    }
}
