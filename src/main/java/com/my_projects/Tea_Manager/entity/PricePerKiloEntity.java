package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "price_per_kilo")
public class PricePerKiloEntity {

    @Id
    private UUID id;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private PriceTypeENUM priceType;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDate enteredDate;
    //private UserEntity enteredUser;

}
