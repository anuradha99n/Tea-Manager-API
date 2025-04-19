package com.my_projects.Tea_Manager.repo;

import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
}
