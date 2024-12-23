package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employee);
    EmployeeDTO get(Long id);
    boolean delete(Long id);
    EmployeeDTO update(EmployeeDTO employee);
}
