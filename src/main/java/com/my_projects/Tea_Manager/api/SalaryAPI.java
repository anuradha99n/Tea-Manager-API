package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.dto.SalaryDTO;
import com.my_projects.Tea_Manager.service.SalaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/salary")
public class SalaryAPI {
    SalaryService salaryService;
    public SalaryAPI(SalaryService salaryService){this.salaryService = salaryService;}

    @GetMapping()
    public ResponseEntity<ApiResponse> getMonthlySalary(
            @RequestParam("employee_id") Long employeeId,
            @RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime startDate,
            @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDateTime endDate)
    {
        try{
            SalaryDTO salaryDTO = salaryService.getMonthlySalaryForEmployee(employeeId, startDate, endDate);
            ApiResponse<SalaryDTO> response = new ApiResponse<>(
                    "success",
                    "Salary Calculated",
                    salaryDTO
            );
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            ApiResponse<Object> response = new ApiResponse<>(
                    "error",
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception ex) {
            ApiResponse<Object> response = new ApiResponse<>(
                    "error",
                    "An unexpected error occurred.",
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
