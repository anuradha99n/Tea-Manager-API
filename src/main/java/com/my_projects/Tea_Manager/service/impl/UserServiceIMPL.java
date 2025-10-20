package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.dto.LoginDTO;
import com.my_projects.Tea_Manager.dto.UserDTO;
import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import com.my_projects.Tea_Manager.entity.UserEntity;
import com.my_projects.Tea_Manager.repo.EmployeeRepo;
import com.my_projects.Tea_Manager.repo.PricePerKiloRepo;
import com.my_projects.Tea_Manager.repo.UserRepo;
import com.my_projects.Tea_Manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity entity = new UserEntity();

        // Generate random UUID for the user ID
        //entity.setId(UUID.randomUUID().toString());

        // Map simple fields
        entity.setUserName(userDTO.getUserName());

        // Encode password
        entity.setPassword(userDTO.getPassword());

        entity.setActive(userDTO.isActive());

        // Map employee if provided
        if (userDTO.getEmployeeId() != null) {
            EmployeeEntity employee = employeeRepo.findById(userDTO.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Invalid Employee ID"));
            entity.setEmployee(employee);
        }

        // Save entity
        UserEntity savedUser = userRepo.save(entity);

        // Map back to DTO
        UserDTO savedDTO = new UserDTO();
        savedDTO.setId(savedUser.getId());
        savedDTO.setUserName(savedUser.getUserName());
        savedDTO.setActive(savedUser.getIsActive());

        if (savedUser.getEmployee() != null) {
            savedDTO.setEmployeeId(savedUser.getEmployee().getEmployeeId());
        }

        return savedDTO;
    }

    @Override
    public UserDTO getUserById(UUID id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(UUID id) {
        return false;
    }

    @Override
    public UserDTO Login(LoginDTO loginDTO) {
        return null;
    }
}
