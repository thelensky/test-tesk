package com.mcb.creditfactory.service.collaterals.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
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
public class AirplaneAdapter implements CollateralObject {
    @Autowired
    private AssessedValueRepository repository;
    private AirplaneDto airplane;

    public AirplaneAdapter(AirplaneDto airplaneDto) {
        this.airplane = airplaneDto;
    }

    @Override
    public BigDecimal getValue() {
        Collaterals collaterals = airplane.getCollaterals();
        if (collaterals == null) {
            return BigDecimal.ZERO;
        }
        List<AssessedValue> assessedValues = repository.findByCollaterals(collaterals);
        assessedValues.sort(Comparator.comparing(AssessedValue::getDate));
        return assessedValues.get(assessedValues.size() - 1).getValue();
    }

    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
