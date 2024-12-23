package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import com.my_projects.Tea_Manager.repository.EmployeeRepository;
import com.my_projects.Tea_Manager.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeServiceIMPL(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeEntity.setContact(employee.getContact());
        employeeEntity.setJoinedDateTime(employee.getJoinedDateTime());
        employeeEntity.setAddress(employee.getAddress());
        try{
            EmployeeEntity save = employeeRepository.save(employeeEntity);
            employee.setId(save.getId());
            return employee;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public EmployeeDTO get(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(optionalEmployeeEntity.isPresent()){
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            try{
                employeeDTO.setId(employeeEntity.getId());
                employeeDTO.setName(employeeEntity.getName());
                employeeDTO.setContact(employeeEntity.getContact());
                employeeDTO.setAddress(employeeEntity.getAddress());
                employeeDTO.setJoinedDateTime(employeeEntity.getJoinedDateTime());
                return employeeDTO;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }else{
            throw new ResourceNotFoundException("Employee with ID " + id + " does not exist.");
//            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employee) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employee.getId());
        if(optionalEmployeeEntity.isPresent()){
            EmployeeEntity entity = optionalEmployeeEntity.get();

            if(employee.getName() != null){
                entity.setName(employee.getName());
            }
            if(employee.getContact() != null){
                entity.setContact(employee.getContact());
            }
            if(employee.getAddress() != null){
                entity.setAddress(employee.getAddress());
            }
            if(employee.getJoinedDateTime() != null){
                entity.setJoinedDateTime(employee.getJoinedDateTime());
            }

            try{
                EmployeeEntity save = employeeRepository.save(entity);
                employee.setId(save.getId());
                employee.setName(save.getName());
                employee.setAddress(save.getAddress());
                employee.setContact(save.getContact());
                employee.setJoinedDateTime(save.getJoinedDateTime());
                return employee;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }
        return null;
    }
}
