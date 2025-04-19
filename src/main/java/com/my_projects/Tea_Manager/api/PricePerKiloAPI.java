package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pricePerKilo")
public class PricePerKiloAPI {

    PricePerKiloService pricePerKiloService;

    public PricePerKiloAPI(PricePerKiloService pricePerKiloService){
        this.pricePerKiloService = pricePerKiloService;
    }
    @GetMapping("/between-dates")
    public ResponseEntity<List<PricePerKiloDTO>> getPricePerKilo(
            @RequestParam LocalDate effectiveDate,
            @RequestParam LocalDate endDate,
            @RequestParam PriceTypeENUM priceType) {

        List<PricePerKiloDTO> result = pricePerKiloService.getPricePerKiloBetweenDatesAndType(effectiveDate, endDate, priceType);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity savePricePerKilo(@RequestBody PricePerKiloDTO pricePerKiloDTO){
        try{
            PricePerKiloDTO save = pricePerKiloService.createPricePerKilo(pricePerKiloDTO);
            ApiResponse<PricePerKiloDTO> response = new ApiResponse<>(
                    HttpStatus.CREATED.toString(),
                    "Price Per Kilo Saved Successfully",
                    save
            );
            return ResponseEntity.ok(response);
        } catch (Exception ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "An Unexpected error occurred.",
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
