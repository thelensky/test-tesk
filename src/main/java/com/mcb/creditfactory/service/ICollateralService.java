package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;

public interface ICollateralService {
    Long saveCollateral(Collateral collateral);

    Collateral getInfo(Collateral collateral);
}
