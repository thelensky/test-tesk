package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;

import java.util.HashMap;
import java.util.Map;

public class CollateralServiceRescuers {
    private static Map<Class<? extends Object>, String> rescuers = new HashMap<>();

    private CollateralServiceRescuers(){}

    static {
        rescuers.put(CarDto.class, "carCollateralService");
        rescuers.put(AirplaneDto.class, "airplaneCollateralService");
    }

    public static String getRescuers(Class<? extends Collateral> aClass) {
        return rescuers.get(aClass);
    }
}
