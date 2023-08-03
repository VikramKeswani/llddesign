package service;

import models.Gate;
import models.Operator;
import models.ParkingLot;
import models.enums.FeesCalculationStrategyType;
import models.enums.GateType;
import repositeries.GateRepository;
import utilities.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public List<Gate> registerGateForParkingLot(ParkingLot parkingLot, int numberOfEntryGates, int numberOfExitGate) {
        List<Gate> gates = new ArrayList<>();
        for (int i = 0; i < numberOfEntryGates; i++) {
            Gate gate = new Gate();
            gate.setGateNumber(Long.valueOf(i));
            gate.setGateType(GateType.ENTRY_GATE);
            gate.setOperator(new Operator());
            gate.setFeesCalculationStrategyType(FeesCalculationStrategyType.FULL);
            Gate gateInfo =gateRepository.saveGateInfo(parkingLot,gate,GateType.ENTRY_GATE);
            gates.add(gateInfo);
        }
        for (int i = 0; i < numberOfExitGate; i++) {
            Gate gate = new Gate();
            gate.setGateNumber(Long.valueOf(i));
            gate.setGateType(GateType.EXIT_GATE);
            gate.setOperator(new Operator());
            gate.setFeesCalculationStrategyType(FeesCalculationStrategyType.FULL);
            Gate gateInfo =gateRepository.saveGateInfo(parkingLot,gate,GateType.EXIT_GATE);
            gates.add(gateInfo);
        }
        return gates;
    }


}
