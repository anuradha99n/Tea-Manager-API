package com.my_projects.Tea_Manager.repo;

import com.my_projects.Tea_Manager.entity.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Repository
public interface DesignationRepo extends JpaRepository<DesignationEntity, String> {

    Optional<DesignationEntity>findById(String id);
}
