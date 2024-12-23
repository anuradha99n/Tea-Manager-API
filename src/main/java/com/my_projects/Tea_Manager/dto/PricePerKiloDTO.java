package com.my_projects.Tea_Manager.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PricePerKiloDTO {
    private Long id;
    private BigDecimal price_per_kilo;
    private LocalDate effective_date;
    private LocalDate end_date;
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
