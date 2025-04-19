package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.common.exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    EmployeeService employeeService;
    public EmployeeAPI(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") String id){
        try{
            EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
            ApiResponse<EmployeeDTO> response = new ApiResponse<>(
                    HttpStatus.OK.toString(),
                    "Employee Exists",
                    employeeDTO
            );
            return ResponseEntity.ok(response);
            //return ResponseEntity.ok(employeeDTO);
        } catch (ResourceNotFoundException ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        try{
            EmployeeDTO save = employeeService.createEmployee(employeeDTO);
            ApiResponse<EmployeeDTO> response = new ApiResponse<>(
                    HttpStatus.CREATED.toString(),
                    "Employee saved Successfully",
                    save
            );
            return ResponseEntity.ok(response);
        }catch (ResourceNotFoundException ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (IllegalArgumentException ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "An Unexpected error occurred.",
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
