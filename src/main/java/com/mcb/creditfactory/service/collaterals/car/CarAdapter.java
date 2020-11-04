package com.mcb.creditfactory.service.collaterals.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.model.Collaterals;
import com.mcb.creditfactory.repository.AssessedValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    @Autowired
    private AssessedValueRepository repository;
    private CarDto car;

    public CarAdapter(CarDto carDto) {
        this.car = carDto;
    }

    @Override
    public BigDecimal getValue() {
//        TODO refactor to save value in AssessedValue table
        Collaterals collaterals = car.getCollaterals();
        if (collaterals == null) {
            return BigDecimal.ZERO;
        }
        List<AssessedValue> assessedValues = repository.findByCollaterals(collaterals);
        assessedValues.sort(Comparator.comparing(AssessedValue::getDate));
        return assessedValues.get(assessedValues.size() - 1).getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}