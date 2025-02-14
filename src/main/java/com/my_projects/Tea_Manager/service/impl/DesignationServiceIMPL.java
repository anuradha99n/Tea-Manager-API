package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.common.exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.DesignationDTO;
import com.my_projects.Tea_Manager.entity.DesignationEntity;
import com.my_projects.Tea_Manager.repo.DesignationRepo;
import com.my_projects.Tea_Manager.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DesignationServiceIMPL implements DesignationService {

    @Autowired
    private DesignationRepo designationRepo;
    @Override
    public DesignationDTO createDesignation(DesignationDTO designationDTO) {
        DesignationEntity entity = new DesignationEntity();
        entity.setDesignationName(designationDTO.getDesignationName());
        entity.setIsActive(designationDTO.getIsActive());
        entity.setCreatedBy(designationDTO.getCreatedBy());
        entity.setCreatedDate(designationDTO.getCreatedDate());

        try {
            DesignationEntity savedEntity = designationRepo.save(entity);
            designationDTO.setId(savedEntity.getId());
            return designationDTO;
        } catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }


    }

    @Override
    public DesignationDTO getDesignationById(UUID id) {
        Optional<DesignationEntity> optionalDesignationEntity = designationRepo.findById(id);
        DesignationDTO designationDTO = new DesignationDTO();
        if(optionalDesignationEntity.isPresent()){
            DesignationEntity designationEntity = optionalDesignationEntity.get();
            try {
                designationDTO.setId(designationEntity.getId());
                designationDTO.setDesignationName(designationEntity.getDesignationName());
                designationDTO.setIsActive(designationEntity.getIsActive());
                designationDTO.setCreatedBy(designationEntity.getCreatedBy());
                designationDTO.setCreatedDate(designationEntity.getCreatedDate());
                return designationDTO;
            } catch (Exception ex){
                ex.printStackTrace();
                throw ex;
            }
        } else {
            throw new ResourceNotFoundException("Designation with ID : " + id + "not exist.");
        }
    }

    @Override
    public List<DesignationDTO> updateDesignation(UUID id, DesignationDTO designationDTO) {
        return null;
    }

    @Override
    public boolean deleteDesignation(UUID id) {
        return false;
    }
}
