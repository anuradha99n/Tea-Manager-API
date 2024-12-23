package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.TeaPickingRecordDTO;
import com.my_projects.Tea_Manager.entity.TeaPickingRecordEntity;
import com.my_projects.Tea_Manager.repository.TeaPickingRecordRepository;
import com.my_projects.Tea_Manager.service.TeaPickingRecordService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeaPickingRecordServiceIMPL implements TeaPickingRecordService {
    private TeaPickingRecordRepository teaPickingRecordRepository;
    public TeaPickingRecordServiceIMPL(TeaPickingRecordRepository teaPickingRecordRepository){
        this.teaPickingRecordRepository = teaPickingRecordRepository;
    }
    @Override
    public TeaPickingRecordDTO save(TeaPickingRecordDTO teaPickingRecord) {
        TeaPickingRecordEntity teaPickingRecordEntity = new TeaPickingRecordEntity();
        teaPickingRecordEntity.setEmployee_id(teaPickingRecord.getEmployee_id());
        teaPickingRecordEntity.setKilos_picked(teaPickingRecord.getKilos_picked());
        teaPickingRecordEntity.setEntered_datetime(teaPickingRecord.getEntered_datetime());
        try{
            TeaPickingRecordEntity save = teaPickingRecordRepository.save(teaPickingRecordEntity);
            teaPickingRecord.setId(save.getId());
            return teaPickingRecord;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TeaPickingRecordDTO get(Long id) {
        Optional<TeaPickingRecordEntity> optionalTeaPickingRecordEntity = teaPickingRecordRepository.findById(id);
        TeaPickingRecordDTO teaPickingRecordDTO = new TeaPickingRecordDTO();
        if(optionalTeaPickingRecordEntity.isPresent()){
            TeaPickingRecordEntity teaPickingRecordEntity = optionalTeaPickingRecordEntity.get();
            try {
                teaPickingRecordDTO.setId((teaPickingRecordEntity.getId()));
                teaPickingRecordDTO.setEmployee_id(teaPickingRecordEntity.getEmployee_id());
                teaPickingRecordDTO.setEntered_datetime(teaPickingRecordEntity.getEntered_datetime());
                teaPickingRecordDTO.setKilos_picked(teaPickingRecordEntity.getKilos_picked());
                return teaPickingRecordDTO;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }else {
            throw new ResourceNotFoundException("Tea Picking Record with ID " + id + " does not exist.");
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TeaPickingRecordDTO update(TeaPickingRecordDTO teaPickingRecord) {
        Optional<TeaPickingRecordEntity> optionalTeaPickingRecordEntity = teaPickingRecordRepository.findById(teaPickingRecord.getId());
        if(optionalTeaPickingRecordEntity.isPresent()){
            TeaPickingRecordEntity entity = optionalTeaPickingRecordEntity.get();

            if (teaPickingRecord.getEmployee_id() != null){
                entity.setEmployee_id(teaPickingRecord.getEmployee_id());
            }
            if(teaPickingRecord.getEntered_datetime() != null){
                entity.setEntered_datetime(teaPickingRecord.getEntered_datetime());
            }
            if(teaPickingRecord.getKilos_picked() != null){
                entity.setKilos_picked(teaPickingRecord.getKilos_picked());
            }

            try {
                TeaPickingRecordEntity save = teaPickingRecordRepository.save(entity);
                teaPickingRecord.setId(save.getId());
                teaPickingRecord.setEmployee_id(save.getEmployee_id());
                teaPickingRecord.setEntered_datetime(save.getEntered_datetime());
                teaPickingRecord.setKilos_picked(save.getKilos_picked());
                return teaPickingRecord;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }
        return null;
    }
}
