package repositeries;

import models.Gate;
import models.ParkingLot;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLotInMemoryDb;

    public static Long id = 1L;

    public ParkingLotRepository() {
        this.parkingLotInMemoryDb = new HashMap<>();
    }

    public ParkingLot saveParkingLotInfo(ParkingLot parkingLot) {
        id = id + 1;
        parkingLot.setId(id);
        return parkingLotInMemoryDb.put(parkingLot.getNumber(), parkingLot);

    }

    public Optional<ParkingLot> getParkingLotInfo(Long parkingLotId) {
        if (parkingLotInMemoryDb.containsKey(parkingLotId))
            return Optional.of(parkingLotInMemoryDb.get(parkingLotId));
        return Optional.empty();
    }

    public Optional<ParkingLot> getParkingLotInfoByGateId(Gate gate) {
        for (ParkingLot parkingLot : parkingLotInMemoryDb.values()) {
            if (parkingLot.getGate().contains(gate))
                return Optional.of(parkingLot);
        }
        return Optional.empty();
    }

}
