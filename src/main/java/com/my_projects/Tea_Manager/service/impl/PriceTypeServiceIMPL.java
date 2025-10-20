package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.dto.PriceTypeDTO;
import com.my_projects.Tea_Manager.entity.PriceTypeEntity;
import com.my_projects.Tea_Manager.repo.PriceTypeRepo;
import com.my_projects.Tea_Manager.service.PriceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceTypeServiceIMPL implements PriceTypeService {

    @Autowired
    PriceTypeRepo priceTypeRepo;
    @Override
    public PriceTypeDTO createPriceType(PriceTypeDTO priceTypeDTO) {
        PriceTypeEntity entity = new PriceTypeEntity();
        entity.setPriceTypeName(priceTypeDTO.getPriceTypeName().toUpperCase());

        PriceTypeEntity savedEntity = priceTypeRepo.save(entity);

        PriceTypeDTO responseDTO = new PriceTypeDTO();
        responseDTO.setPriceTypeId(savedEntity.getPriceTypeId());
        responseDTO.setPriceTypeName(savedEntity.getPriceTypeName());

        return responseDTO;

    }
}
