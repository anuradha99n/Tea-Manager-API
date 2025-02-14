package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(UUID id);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO);
}
