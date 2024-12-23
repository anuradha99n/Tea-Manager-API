package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    EmployeeService employeeService;
    public EmployeeAPI(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") Long id){
        try {
            EmployeeDTO employeeDTO = employeeService.get(id);
            return ResponseEntity.ok(employeeDTO);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO save = employeeService.save(employeeDTO);
        return ResponseEntity.ok(save);
    }

    @PatchMapping
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO save = employeeService.update(employeeDTO);
        if(save != null){
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.status(404).build();

    }
}
