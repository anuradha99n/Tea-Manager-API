package com.my_projects.Tea_Manager.dto;

import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricePerKiloDTO {

    private String id;
    private BigDecimal price;
    private String priceTypeId;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDateTime enteredDate;
    private String enteredUserId;
    //private UserEntity enteredUser;
}
