package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "price_per_kilo_version")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricePerKiloVersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String pricePerKiloVersionId;

    @ManyToOne
    @JoinColumn(name = "price_per_kilo_id", nullable = false)
    private PricePerKiloEntity pricePerKilo;

    @Column(nullable = false)
    private LocalDate effectiveDate;
    private LocalDate endDate;
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate = LocalDate.now();
    private int version;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity createdUser;

}

