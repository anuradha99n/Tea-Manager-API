package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.PriceTypeENUM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "price_per_kilo")
public class PricePerKiloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String pricePerKiloId;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDateTime enteredDate;

    @ManyToOne
    @JoinColumn(name = "price_type_id")
    private PriceTypeEntity priceType;
//    private UserEntity enteredUser;
//    private BigDecimal price;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, length = 50)
//    private PriceTypeENUM priceType;
}
