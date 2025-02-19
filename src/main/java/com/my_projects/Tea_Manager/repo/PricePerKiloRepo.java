package com.my_projects.Tea_Manager.repo;

import com.my_projects.Tea_Manager.entity.PricePerKiloEntity;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PricePerKiloRepo extends JpaRepository<PricePerKiloEntity, UUID> {

    @Override
    Optional<PricePerKiloEntity> findById(UUID uuid);

    @Query("SELECT p FROM PricePerKiloEntity p WHERE p.effectiveDate BETWEEN :effectiveDate AND :endDate AND p.priceType = :priceType")
    List<PricePerKiloEntity> getPricePerKiloBetweenDatesAndType(
            @Param("effectiveDate") LocalDate effectiveDate,
            @Param("endDate") LocalDate endDate,
            @Param("priceType") PriceTypeENUM priceType
    );
}
