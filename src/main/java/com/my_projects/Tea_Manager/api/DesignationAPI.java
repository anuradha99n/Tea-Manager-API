package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.common.exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.DesignationDTO;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.service.DesignationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/designation")
public class DesignationAPI {
    DesignationService designationService;
    public DesignationAPI(DesignationService designationService){
        this.designationService = designationService;
    }

    @PostMapping
    public ResponseEntity saveDesignation(@RequestBody DesignationDTO designationDTO){
        DesignationDTO save = designationService.createDesignation(designationDTO);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDesignation(@PathVariable("id") UUID id){
        try{
            DesignationDTO designationDTO = designationService.getDesignationById(id);
            ApiResponse<DesignationDTO> response = new ApiResponse<>(
                    HttpStatus.OK.toString(),
                    "Designation Exists",
                    designationDTO
            );
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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
}
