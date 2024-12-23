package com.my_projects.Tea_Manager.service.impl;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.entity.PricePerKiloEntity;
import com.my_projects.Tea_Manager.entity.PriceTypeENUM;
import com.my_projects.Tea_Manager.repository.PricePerKiloRepository;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PricePerKiloServiceIMPL implements PricePerKiloService {
    private PricePerKiloRepository pricePerKiloRepository;
    public PricePerKiloServiceIMPL(PricePerKiloRepository pricePerKiloRepository){
        this.pricePerKiloRepository = pricePerKiloRepository;
    }
    @Override
    public PricePerKiloDTO save(PricePerKiloDTO pricePerKilo) {
        PricePerKiloEntity pricePerKiloEntity = new PricePerKiloEntity();
        pricePerKiloEntity.setPrice_per_kilo(pricePerKilo.getPrice_per_kilo());
        pricePerKiloEntity.setPriceType(pricePerKilo.getPriceType());
        pricePerKiloEntity.setEffective_date(pricePerKilo.getEffective_date());
        pricePerKiloEntity.setEnd_date(pricePerKilo.getEnd_date());
        try{
            PricePerKiloEntity save = pricePerKiloRepository.save(pricePerKiloEntity);
            pricePerKilo.setId(save.getId());
            return pricePerKilo;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PricePerKiloDTO get(Long id) {
        Optional<PricePerKiloEntity> optionalPricePerKiloEntity = pricePerKiloRepository.findById(id);
        PricePerKiloDTO pricePerKiloDTO = new PricePerKiloDTO();
        if(optionalPricePerKiloEntity.isPresent()){
            PricePerKiloEntity pricePerKilo = optionalPricePerKiloEntity.get();
            try {
                pricePerKiloDTO.setId(pricePerKilo.getId());
                pricePerKiloDTO.setPrice_per_kilo(pricePerKilo.getPrice_per_kilo());
                pricePerKiloDTO.setEffective_date(pricePerKilo.getEffective_date());
                pricePerKiloDTO.setEnd_date(pricePerKilo.getEnd_date());
                pricePerKiloDTO.setPriceType(pricePerKilo.getPriceType());
                return pricePerKiloDTO;
            } catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        } else{
            throw new ResourceNotFoundException("Price with ID " + id + " does not exist.");
        }
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public PricePerKiloDTO update(PricePerKiloDTO pricePerKilo) {
        return null;
    }
}
