package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.SalaryDTO;

import java.time.LocalDateTime;

public interface SalaryService {

    SalaryDTO getMonthlySalaryForEmployee(Long employeeId, LocalDateTime startDate, LocalDateTime endDate);
}
