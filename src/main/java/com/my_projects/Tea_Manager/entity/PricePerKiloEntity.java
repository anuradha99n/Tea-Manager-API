package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "price_per_kilo")
public class PricePerKiloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private PriceTypeENUM priceType;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDate enteredDate;
    //private UserEntity enteredUser;
}
