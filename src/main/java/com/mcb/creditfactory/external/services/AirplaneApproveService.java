package com.mcb.creditfactory.external.services;

import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.IExternalApproveService;
import org.springframework.stereotype.Service;

@Service
public class AirplaneApproveService implements IExternalApproveService {
    @Override
    public int approve(CollateralObject object) {
        // TODO needs implementation;
        return 1;
    }
}
