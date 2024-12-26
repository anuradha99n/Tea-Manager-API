package com.my_projects.Tea_Manager.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SalaryDTO {
    PricePerKiloDTO pricePerKiloDTO;
    BigDecimal monthlySalary;
    EmployeeDTO employeeDTO;
    LocalDateTime enteredDateTime;

    public PricePerKiloDTO getPricePerKiloDTO() {
        return pricePerKiloDTO;
    }

    public void setPricePerKiloDTO(PricePerKiloDTO pricePerKiloDTO) {
        this.pricePerKiloDTO = pricePerKiloDTO;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public LocalDateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public void setEnteredDateTime(LocalDateTime enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }
}

