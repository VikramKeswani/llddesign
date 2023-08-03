package repositeries;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    Map<Long,Gate> gateInfoInMemory;

    public GateRepository() {
        this.gateInfoInMemory = new HashMap<>();
    }

    public Optional<Gate> getGateInfo(Long gateId){
        return null;
    }

    public void saveGateInfo(Long gateId,Gate gate){
        gateInfoInMemory.put(gateId,gate);
    }
}
