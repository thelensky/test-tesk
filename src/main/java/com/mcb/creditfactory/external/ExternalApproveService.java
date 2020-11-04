package com.mcb.creditfactory.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ExternalApproveService implements IExternalApproveService {
    @Autowired
    Map<String, IExternalApproveService> collateralObjectMap = new HashMap<>();

    @Override
    public int approve(CollateralObject object) {
        IExternalApproveService service = collateralObjectMap.get(ExternalApproveServiceResource.getRescuers(object.getClass()));
        return service.approve(object);
    }
}
