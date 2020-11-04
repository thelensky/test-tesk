package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.model.Collaterals;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssessedValueRepository extends CrudRepository<AssessedValue, Long> {
    List<AssessedValue> findByCollaterals(Collaterals collaterals);
}
