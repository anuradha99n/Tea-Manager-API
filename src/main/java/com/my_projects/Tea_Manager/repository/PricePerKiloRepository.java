package com.my_projects.Tea_Manager.repository;

import com.my_projects.Tea_Manager.entity.PricePerKiloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PricePerKiloRepository extends JpaRepository<PricePerKiloEntity, Long> {
    Optional<PricePerKiloEntity> findFirstByEffectiveDateBetweenAndPriceType(LocalDate effectiveDate, LocalDate endDate, Integer priceType);
}
