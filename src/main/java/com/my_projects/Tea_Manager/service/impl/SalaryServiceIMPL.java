package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.dto.SalaryDTO;
import com.my_projects.Tea_Manager.dto.TeaPickingRecordDTO;
import com.my_projects.Tea_Manager.entity.PriceTypeENUM;
import com.my_projects.Tea_Manager.repository.TeaPickingRecordRepository;
import com.my_projects.Tea_Manager.service.EmployeeService;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import com.my_projects.Tea_Manager.service.SalaryService;
import com.my_projects.Tea_Manager.service.TeaPickingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalaryServiceIMPL implements SalaryService {
    @Autowired
    private TeaPickingRecordRepository teaPickingRecordRepository;
    @Autowired
    private PricePerKiloService pricePerKiloService;
    @Autowired
    private TeaPickingRecordService teaPickingRecordService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public SalaryDTO getMonthlySalaryForEmployee(Long employeeId, LocalDateTime startDate, LocalDateTime endDate) {
        List<TeaPickingRecordDTO> teaPickingRecordsList = teaPickingRecordRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
        if (teaPickingRecordsList.isEmpty()) {
            throw new ResourceNotFoundException("No tea-picking records found for the specified period.");
        }
        BigDecimal totalKilosPicked = teaPickingRecordService.getTotalKilosPicked(teaPickingRecordsList);
        PricePerKiloDTO pricePerKiloDTO = pricePerKiloService.getSinglePricePerKiloByDateAndType(
                startDate.toLocalDate(),
                endDate.toLocalDate(),
                PriceTypeENUM.EMPLOYEE.getValue()
        );
        BigDecimal pricePerKilo = pricePerKiloDTO.getPrice_per_kilo();
        BigDecimal monthlySalary = totalKilosPicked.multiply(pricePerKilo);

        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setEmployeeDTO(employeeService.get(employeeId));
        salaryDTO.setMonthlySalary(monthlySalary);
        salaryDTO.setPricePerKiloDTO(pricePerKiloDTO);
        salaryDTO.setEnteredDateTime(LocalDateTime.now());
        return salaryDTO;
    }
}
