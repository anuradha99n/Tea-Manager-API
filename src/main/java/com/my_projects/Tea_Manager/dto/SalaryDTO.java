package com.my_projects.Tea_Manager.dto;

import com.my_projects.Tea_Manager.enums.SalaryStatusENUM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {

    private UUID id;
    private BigDecimal totalPickedTea;
    private BigDecimal salary;
    private SalaryStatusENUM status;
    private PricePerKiloDTO pricePerKilo;
    private EmployeeDTO createdUser;
    private LocalDate createdDate;
    private EmployeeDTO approvedUser;
    private LocalDate approvedDate;
    private EmployeeDTO paidUser;
    private LocalDate paidDate;
    private EmployeeDTO rejectedUser;
    private LocalDate rejectedDate;
    private String rejectedReason;
    private EmployeeDTO updatedUser;
    private LocalDate updatedDate;
}
