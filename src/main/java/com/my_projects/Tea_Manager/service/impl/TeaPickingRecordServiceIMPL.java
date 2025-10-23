package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.dto.TeaPickingRecordInputDTO;
import com.my_projects.Tea_Manager.entity.EmployeeEntity;
import com.my_projects.Tea_Manager.entity.TeaPickingRecordEntity;
import com.my_projects.Tea_Manager.entity.UserEntity;
import com.my_projects.Tea_Manager.repo.EmployeeRepo;
import com.my_projects.Tea_Manager.repo.TeaPickingRecordRepo;
import com.my_projects.Tea_Manager.repo.UserRepo;
import com.my_projects.Tea_Manager.service.TeaPickingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TeaPickingRecordServiceIMPL implements TeaPickingService {
    @Autowired
    private TeaPickingRecordRepo teaPickingRecordRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean SaveTeaPickingRecord(TeaPickingRecordInputDTO dto) {
        try{
            Optional<EmployeeEntity> employeeOpt = employeeRepo.findById(dto.getEmployeeId());
            Optional<UserEntity> userOpt = userRepo.findById(dto.getEnteredUserId());

            if(employeeOpt.isEmpty() || userOpt.isEmpty()){
                return false;
            }

            TeaPickingRecordEntity entity = new TeaPickingRecordEntity();

            entity.setEmployee(employeeOpt.get());
            entity.setPickedAmount(dto.getPickedAmount());
            entity.setWaterWeight(dto.getWaterWeight());
            entity.setBagWeight(dto.getBagWeight());
            entity.setEnteredUser(userOpt.get());

            teaPickingRecordRepo.save(entity);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
