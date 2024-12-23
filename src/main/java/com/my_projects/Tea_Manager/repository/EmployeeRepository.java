package com.my_projects.Tea_Manager.repository;

import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
