package com.my_projects.Tea_Manager.repo;

import com.my_projects.Tea_Manager.entity.PricePerKiloVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PricePerKiloVersionRepo extends JpaRepository<PricePerKiloVersionEntity, UUID> {

    @Query("SELECT MAX(v.version) FROM PricePerKiloVersionEntity v WHERE v.pricePerKilo.pricePerKiloId = :pricePerKiloId")
    Integer findMaxVersionByPricePerKilo(@Param("pricePerKiloId") String pricePerKiloId);

    @Query("SELECT v FROM PricePerKiloVersionEntity v WHERE v.pricePerKilo.pricePerKiloId = :pricePerKiloId AND v.active = true")
    PricePerKiloVersionEntity findActiveVersionByPricePerKilo(@Param("pricePerKiloId") String pricePerKiloId);
}
