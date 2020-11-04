package com.mcb.creditfactory.external.services;

import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.IExternalApproveService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class CarApproveService implements IExternalApproveService {
    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_CAR_YEAR = 2000;
    private static final BigDecimal MIN_CAR_VALUE = BigDecimal.valueOf(1000000);
    private static final int MIN_PLANE_YEAR = 1991;
    private static final BigDecimal MIN_PLANE_VALUE = BigDecimal.valueOf(230000000);

    @Override
    public int approve(CollateralObject object) {
//        TODO refactor
//        if (object.getDate() == null || object.getYear() == null || object.getValue() == null || object.getType() == null) {
//            return -1;
//        }
//
//        if (object.getYear() < MIN_CAR_YEAR) {
//            return -10;
//        }
//        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
//            return -11;
//        }
//        if (object.getValue().compareTo(MIN_CAR_VALUE) < 0) {
//            return -12;
//        }

        return 0;
    }
}
