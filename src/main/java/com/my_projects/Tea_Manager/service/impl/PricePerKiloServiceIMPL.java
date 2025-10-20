package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.entity.PricePerKiloEntity;
import com.my_projects.Tea_Manager.entity.PricePerKiloVersionEntity;
import com.my_projects.Tea_Manager.entity.PriceTypeEntity;
import com.my_projects.Tea_Manager.entity.UserEntity;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import com.my_projects.Tea_Manager.repo.PricePerKiloRepo;
import com.my_projects.Tea_Manager.repo.PricePerKiloVersionRepo;
import com.my_projects.Tea_Manager.repo.PriceTypeRepo;
import com.my_projects.Tea_Manager.repo.UserRepo;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricePerKiloServiceIMPL implements PricePerKiloService {

    @Autowired
    private PricePerKiloRepo pricePerKiloRepo;
    @Autowired
    private PricePerKiloVersionRepo pricePerKiloVersionRepo;
    @Autowired
    private PriceTypeRepo priceTypeRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    @Transactional
    public PricePerKiloDTO createPricePerKilo(PricePerKiloDTO pricePerKiloDTO) {

        try {
            if (pricePerKiloDTO.getId() == null || pricePerKiloDTO.getId().isEmpty()) {
                PricePerKiloEntity entity = new PricePerKiloEntity();

                PriceTypeEntity priceType = priceTypeRepo.findById(pricePerKiloDTO.getPriceTypeId())
                        .orElseThrow(() -> new RuntimeException("Invalid PriceType ID"));
                entity.setPriceType(priceType);

                entity.setEffectiveDate(pricePerKiloDTO.getEffectiveDate());
                entity.setEndDate(pricePerKiloDTO.getEndDate());
                entity.setEnteredDate(LocalDateTime.now());

                PricePerKiloEntity savedEntity = pricePerKiloRepo.save(entity);

                // Create First Version
                PricePerKiloVersionEntity versionEntity = new PricePerKiloVersionEntity();
                versionEntity.setPricePerKilo(savedEntity);
                versionEntity.setEffectiveDate(pricePerKiloDTO.getEffectiveDate());
                versionEntity.setEndDate(pricePerKiloDTO.getEndDate());
                versionEntity.setCreatedDate(LocalDate.now());
                versionEntity.setVersion(1);
                versionEntity.setPrice(pricePerKiloDTO.getPrice());
                versionEntity.setActive(true);
                UserEntity createduser = userRepo.findById(pricePerKiloDTO.getEnteredUserId())
                        .orElseThrow(() -> new RuntimeException("Invalid User ID"));
                versionEntity.setCreatedUser(createduser);

                pricePerKiloVersionRepo.save(versionEntity);

                pricePerKiloDTO.setId(savedEntity.getPricePerKiloId());
                pricePerKiloDTO.setEnteredDate(savedEntity.getEnteredDate());

                return pricePerKiloDTO;
            }
            else{
                PricePerKiloEntity existingEntity = pricePerKiloRepo.findById(pricePerKiloDTO.getId())
                        .orElseThrow(() -> new RuntimeException("PricePerKilo not found"));

                // deactivate the currently active version
                PricePerKiloVersionEntity activeVersion = pricePerKiloVersionRepo
                        .findActiveVersionByPricePerKilo(existingEntity.getPricePerKiloId());
                if (activeVersion != null) {
                    activeVersion.setActive(false);
                    pricePerKiloVersionRepo.save(activeVersion);
                }

                // create new version
                PricePerKiloVersionEntity newVersion = new PricePerKiloVersionEntity();
                newVersion.setPricePerKilo(existingEntity);
                newVersion.setEffectiveDate(pricePerKiloDTO.getEffectiveDate());
                newVersion.setEndDate(pricePerKiloDTO.getEndDate());
                newVersion.setCreatedDate(LocalDate.now());
                newVersion.setVersion(getNextVersion(existingEntity.getPricePerKiloId()));
                newVersion.setPrice(pricePerKiloDTO.getPrice());
                newVersion.setActive(true);

                UserEntity createduser = userRepo.findById(pricePerKiloDTO.getEnteredUserId())
                        .orElseThrow(() -> new RuntimeException("Invalid User ID"));
                newVersion.setCreatedUser(createduser);

                pricePerKiloVersionRepo.save(newVersion);

                pricePerKiloDTO.setEnteredDate(existingEntity.getEnteredDate());

                return pricePerKiloDTO;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<PricePerKiloDTO> getPricePerKiloBetweenDatesAndType(LocalDate effectiveDate, LocalDate endDate, PriceTypeENUM priceType) {
        List<PricePerKiloEntity> pricePerKiloEntitiesList = pricePerKiloRepo.getPricePerKiloBetweenDatesAndType(effectiveDate, endDate, priceType);


        return pricePerKiloEntitiesList.stream()
                .map(entity -> {
                    PricePerKiloDTO dto = new PricePerKiloDTO();
//                    dto.setId(entity.getId());
//                    dto.setPrice(entity.getPrice());
//                    dto.setPriceType(entity.getPriceType());
                    dto.setEffectiveDate(entity.getEffectiveDate());
                    dto.setEndDate(entity.getEndDate());
                    dto.setEnteredDate(entity.getEnteredDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private int getNextVersion(String pricePerKiloId){
        Integer maxversion = pricePerKiloVersionRepo.findMaxVersionByPricePerKilo(pricePerKiloId);
        return (maxversion == null) ? 1 : maxversion + 1;
    }
}
