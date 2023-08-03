package dto;

import models.enums.VechileType;

public class TicketRequestDto {
    private String vechileNumber;
    private String vechileOwnerName;
    private VechileType vechileType;
    private Long gateId;

    public String getVechileNumber() {
        return vechileNumber;
    }

    public void setVechileNumber(String vechileNumber) {
        this.vechileNumber = vechileNumber;
    }

    public String getVechileOwnerName() {
        return vechileOwnerName;
    }

    public void setVechileOwnerName(String vechileOwnerName) {
        this.vechileOwnerName = vechileOwnerName;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
