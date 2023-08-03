package repositeries;

import models.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    Map<String, Vehicle> vehicleMap;

    public VehicleRepository() {
        this.vehicleMap = new HashMap<>();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setCreatedAt(new Date());
        vehicle.setUpdatedAt(new Date());
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> getVehicleInfo(String vehicleId) {
        if (vehicleMap.containsKey(vehicleId))
            return Optional.of(vehicleMap.get(vehicleId));

        return Optional.empty();
    }

}
