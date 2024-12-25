package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "price_per_kilo")
public class PricePerKiloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal pricePerKilo;
    @Column(nullable = false)
    private LocalDate effectiveDate;
    @Column(nullable = true)
    private LocalDate endDate;
//    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Integer priceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice_per_kilo() {
        return pricePerKilo;
    }

    public void setPrice_per_kilo(BigDecimal price_per_kilo) {
        this.pricePerKilo = price_per_kilo;
    }

    public LocalDate getEffective_date() {
        return effectiveDate;
    }

    public void setEffective_date(LocalDate effective_date) {
        this.effectiveDate = effective_date;
    }

    public LocalDate getEnd_date() {
        return endDate;
    }

    public void setEnd_date(LocalDate end_date) {
        this.endDate = end_date;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }
}
