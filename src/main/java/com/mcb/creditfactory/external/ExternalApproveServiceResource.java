package com.mcb.creditfactory.external;

import com.mcb.creditfactory.service.collaterals.airplane.AirplaneAdapter;
import com.mcb.creditfactory.service.collaterals.car.CarAdapter;

import java.util.HashMap;
import java.util.Map;

public class ExternalApproveServiceResource {
    private static Map<Class<? extends CollateralObject>, String> resource = new HashMap<>();
    private ExternalApproveServiceResource (){}

    static {
        resource.put(CarAdapter.class,"carApproveService");
        resource.put(AirplaneAdapter.class,"airplaneApproveService");
    }

    public static String getRescuers(Class<? extends CollateralObject> aClass) {
        return resource.get(aClass);
    }
}
