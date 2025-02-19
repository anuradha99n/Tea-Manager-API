package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.entity.PricePerKiloEntity;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import com.my_projects.Tea_Manager.repo.PricePerKiloRepo;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricePerKiloServiceIMPL implements PricePerKiloService {

    @Autowired
    private PricePerKiloRepo pricePerKiloRepo;
    @Override
    public PricePerKiloDTO createPricePerKilo(PricePerKiloDTO pricePerKiloDTO) {
        return null;
    }

    @Override
    public List<PricePerKiloDTO> getPricePerKiloBetweenDatesAndType(LocalDate effectiveDate, LocalDate endDate, PriceTypeENUM priceType) {
        List<PricePerKiloEntity> pricePerKiloEntitiesList = pricePerKiloRepo.getPricePerKiloBetweenDatesAndType(effectiveDate, endDate, priceType);


        return pricePerKiloEntitiesList.stream()
                .map(entity -> {
                    PricePerKiloDTO dto = new PricePerKiloDTO();
                    dto.setId(entity.getId());
                    dto.setPrice(entity.getPrice());
                    dto.setPriceType(entity.getPriceType());
                    dto.setEffectiveDate(entity.getEffectiveDate());
                    dto.setEndDate(entity.getEndDate());
                    dto.setEnteredDate(entity.getEnteredDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
