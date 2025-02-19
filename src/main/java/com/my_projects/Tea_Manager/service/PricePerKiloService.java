package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;

import java.time.LocalDate;
import java.util.List;

public interface PricePerKiloService {

    PricePerKiloDTO createPricePerKilo(PricePerKiloDTO pricePerKiloDTO);
    List<PricePerKiloDTO> getPricePerKiloBetweenDatesAndType(LocalDate effectiveDate, LocalDate endDate, PriceTypeENUM priceType);
}
