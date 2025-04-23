package com.my_projects.Tea_Manager.dto;

import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricePerKiloDTO {

    private String id;
    private BigDecimal price;
    private PriceTypeENUM priceType;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDate enteredDate;
    //private UserEntity enteredUser;
}
