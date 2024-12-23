package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.dto.PricePerKiloDTO;
import com.my_projects.Tea_Manager.service.PricePerKiloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricePerKilo")
public class PricePerKiloAPI {
    PricePerKiloService pricePerKiloService;
    public PricePerKiloAPI(PricePerKiloService pricePerKiloService){
        this.pricePerKiloService=pricePerKiloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getPricePerKilo(@PathVariable("id") Long id){
        try{
            PricePerKiloDTO pricePerKiloDTO = pricePerKiloService.get(id);
            return ResponseEntity.ok(pricePerKiloDTO);
        } catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PostMapping
    public ResponseEntity savePricePerKilo(@RequestBody PricePerKiloDTO pricePerKiloDTO){
//        PricePerKiloDTO save = pricePerKiloService.save(pricePerKiloDTO);
//        return ResponseEntity.ok(save);

        try {
            PricePerKiloDTO savedPricePerKilo = pricePerKiloService.save(pricePerKiloDTO);
            ApiResponse<PricePerKiloDTO> response = new ApiResponse<>("success", "PricePerKilo saved successfully", savedPricePerKilo);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            ApiResponse<Object> response = new ApiResponse<>("error", e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ApiResponse<Object> response = new ApiResponse<>("error", "An unexpected error occurred", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
