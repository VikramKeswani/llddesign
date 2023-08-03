package controller;

import dto.ParkingLotRegisterRequestDto;
import dto.ParkingLotRegisterResponseDto;
import models.ParkingLot;
import service.ParkingLotService;

import java.util.Date;

public class ParkingLotController {

    ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingLotRegisterResponseDto registerParkingLot(ParkingLotRegisterRequestDto parkingLotRegisterRequestDto){

        ParkingLotRegisterResponseDto parkingLotRegisterResponseDto = new ParkingLotRegisterResponseDto();

        try{
            ParkingLot parkingLot = parkingLotService.registerParkingLot(parkingLotRegisterRequestDto.getFloors(),parkingLotRegisterRequestDto.getEntryGates(),parkingLotRegisterRequestDto.getExitGate(),parkingLotRegisterRequestDto.getAllowedVehicleTypes());
            parkingLotRegisterResponseDto.setParkingLot(parkingLot);
            parkingLotRegisterResponseDto.setMessage("SUCCESS");
            parkingLotRegisterResponseDto.setStatus(200);
            parkingLotRegisterResponseDto.setTimeStamp(new Date());
        }
        catch (Exception e){
            parkingLotRegisterResponseDto.setTimeStamp(new Date());
            parkingLotRegisterResponseDto.setStatus(400);
            parkingLotRegisterResponseDto.setMessage("FAILURE");
            return parkingLotRegisterResponseDto;
        }
        return parkingLotRegisterResponseDto;
    }
}

