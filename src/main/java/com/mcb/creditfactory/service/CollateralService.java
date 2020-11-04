package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.collateral.CollateralServiceRescuers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CollateralService {
    @Autowired
    private Map<String, ICollateralService> collateralMap = new HashMap<>();

    public Long saveCollateral(Collateral collateral) {
        ICollateralService service = collateralMap.get(CollateralServiceRescuers.getRescuers(collateral.getClass()));
        return service.saveCollateral(collateral);
    }

    public Collateral getInfo(Collateral collateral) {
        ICollateralService service = collateralMap.get(CollateralServiceRescuers.getRescuers(collateral.getClass()));
        return service.getInfo(collateral);
    }
}
