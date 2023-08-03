package utilities;

import models.enums.VechileType;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CommonUtil {

    private static CommonUtil commonUtil;

    private static Long parkingLotNumber=0L;

    private CommonUtil() {

    }


    public static CommonUtil getInstance() {
        if (commonUtil == null) {
            synchronized (CommonUtil.class) {
                if (commonUtil == null) {
                    commonUtil = new CommonUtil();
                }
            }
        }
        return commonUtil;
    }

    public Long generateRandomNumber() {
        return Long.valueOf(UUID.randomUUID().toString());
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static <T extends Enum<?>> T getRandomFromListEnum(List<T> listOfEnum) {
        Random random = new Random();
        int pick = random.nextInt(listOfEnum.size());
        return listOfEnum.get(pick);
    }


    public static Long getParkingLotNumber(){
        parkingLotNumber = parkingLotNumber+1;
        return parkingLotNumber;
    }

}
