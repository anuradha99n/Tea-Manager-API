package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.common.exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.DesignationDTO;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.entity.DesignationEntity;
import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import com.my_projects.Tea_Manager.repo.DesignationRepo;
import com.my_projects.Tea_Manager.repo.EmployeeRepo;
import com.my_projects.Tea_Manager.service.DesignationService;
import com.my_projects.Tea_Manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DesignationRepo designationRepo;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeDTO.getName());
        entity.setContact(employeeDTO.getContact());
        entity.setAddress(employeeDTO.getAddress());
        entity.setJoinedDate(employeeDTO.getJoinedDate());
        entity.setIsActive(employeeDTO.getIsActive());
        if(employeeDTO.getDesignationId() != null){
            Optional<DesignationEntity> optionalDesignationEntity = designationRepo.findById(employeeDTO.getDesignationId());
            if(optionalDesignationEntity.isPresent()){
                DesignationEntity designationEntity = optionalDesignationEntity.get();
                try {
                    entity.setDesignation(designationEntity);
                } catch (Exception ex){
                    ex.printStackTrace();
                    throw ex;
                }
            } else {
                throw new ResourceNotFoundException("Designation not found with ID: " + employeeDTO.getDesignationId());
            }
        } else {
            throw  new IllegalArgumentException("Designation ID must be provided!");
        }

        // Save the EmployeeEntity
        try {
            EmployeeEntity savedEntity = employeeRepo.save(entity);
            employeeDTO.setId(savedEntity.getId());
            return employeeDTO;
        } catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        System.out.println("🔍 Searching for employee with ID: " + id);
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepo.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(optionalEmployeeEntity.isPresent()){
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            try {
                employeeDTO.setId(employeeEntity.getId());
                employeeDTO.setName(employeeEntity.getName());
                employeeDTO.setContact(employeeEntity.getContact());
                employeeDTO.setJoinedDate(employeeEntity.getJoinedDate());
                employeeDTO.setIsActive(employeeEntity.getIsActive());
                employeeDTO.setAddress(employeeEntity.getAddress());
                employeeDTO.setDesignationId(employeeEntity.getDesignation().getId());

                return employeeDTO;
            } catch (Exception ex){
                ex.printStackTrace();
                throw ex;
            }
        } else {
            throw new ResourceNotFoundException("Employee with ID " + id + " does not exist.");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        return null;
    }
}
