package repositeries;

import models.Gate;
import models.ParkingLot;
import models.enums.GateType;
import utilities.CommonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    CommonUtil commonUtil;
    Map<String,Gate> gateInfoInMemory;

    public GateRepository(CommonUtil commonUtil) {
        this.gateInfoInMemory = new HashMap<>();
        this.commonUtil = commonUtil;
    }

    public Optional<Gate> getGateInfo(Long gateId){
        return null;
    }

    public Gate saveGateInfo(ParkingLot parkingLot, Gate gate, GateType gateType){
        String gateId = commonUtil.generateGateKey(parkingLot.getNumber(),gate.getGateNumber(),gateType);
        gate.setCreatedAt(new Date());
        gate.setUpdatedAt(new Date());
        gateInfoInMemory.put(gateId,gate);
        return gate;
    }
}
