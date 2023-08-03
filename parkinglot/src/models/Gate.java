package models;

import models.enums.FeesCalculationStrategyType;
import models.enums.GateType;

public class Gate extends BaseClass {
    private Long gateNumber;
    private GateType gateType;
    private Operator operator;
    private FeesCalculationStrategyType feesCalculationStrategyType;
    private Long parkingLotNumber;

    public Long getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Long gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public FeesCalculationStrategyType getFeesCalculationStrategyType() {
        return feesCalculationStrategyType;
    }

    public void setFeesCalculationStrategyType(FeesCalculationStrategyType feesCalculationStrategyType) {
        this.feesCalculationStrategyType = feesCalculationStrategyType;
    }
}
