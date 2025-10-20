package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.dto.PriceTypeDTO;
import com.my_projects.Tea_Manager.service.PriceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priceType")
public class PriceTypeAPI {

    @Autowired
    PriceTypeService priceTypeService;

    @PostMapping
    public ResponseEntity savePriceType(@RequestBody PriceTypeDTO priceTypeDTO){
        PriceTypeDTO save = priceTypeService.createPriceType(priceTypeDTO);
        ApiResponse<PriceTypeDTO> response = new ApiResponse<>(
                HttpStatus.CREATED.toString(),
                "PriceType saved Successfully",
                save
        );
        return ResponseEntity.ok(response);
    }
}
