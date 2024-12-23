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
    private BigDecimal price_per_kilo;
    @Column(nullable = false)
    private LocalDate effective_date;
    @Column(nullable = true)
    private LocalDate end_date;
//    @Enumerated(EnumType.ORDINAL)
    @Column(name = "price_type", nullable = false)
    private Integer price_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice_per_kilo() {
        return price_per_kilo;
    }

    public void setPrice_per_kilo(BigDecimal price_per_kilo) {
        this.price_per_kilo = price_per_kilo;
    }

    public LocalDate getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(LocalDate effective_date) {
        this.effective_date = effective_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Integer getPriceType() {
        return price_type;
    }

    public void setPriceType(Integer priceType) {
        this.price_type = priceType;
    }
}
