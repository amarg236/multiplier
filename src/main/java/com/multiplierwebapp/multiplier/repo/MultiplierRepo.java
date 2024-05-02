package com.multiplierwebapp.multiplier.repo;

import com.multiplierwebapp.multiplier.model.MultiplierData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplierRepo extends JpaRepository<MultiplierData, Long> {
}
