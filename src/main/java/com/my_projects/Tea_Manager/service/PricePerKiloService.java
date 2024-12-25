package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;

import java.time.LocalDate;

public interface PricePerKiloService {
    PricePerKiloDTO save(PricePerKiloDTO pricePerKilo);
    PricePerKiloDTO get(Long id);
    Boolean delete(Long id);
    PricePerKiloDTO update(PricePerKiloDTO pricePerKilo);

    PricePerKiloDTO getSinglePricePerKiloByDateAndType(LocalDate effectiveDate, LocalDate endDate, Integer priceType);

}
