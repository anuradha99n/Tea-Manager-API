package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pricePerKilo")
public class PricePerKiloAPI {

    @Autowired
    private PricePerKiloService pricePerKiloService;
    @GetMapping("/between-dates")
    public ResponseEntity<List<PricePerKiloDTO>> getPricePerKilo(
            @RequestParam LocalDate effectiveDate,
            @RequestParam LocalDate endDate,
            @RequestParam PriceTypeENUM priceType) {

        List<PricePerKiloDTO> result = pricePerKiloService.getPricePerKiloBetweenDatesAndType(effectiveDate, endDate, priceType);
        return ResponseEntity.ok(result);
    }
}
