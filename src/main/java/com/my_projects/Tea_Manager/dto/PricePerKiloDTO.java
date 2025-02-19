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

    private UUID id;
    private BigDecimal price;
    private PriceTypeENUM priceType;
    private LocalDate effectiveDate;
    private LocalDate endDate;
    private LocalDate enteredDate;
    //private UserEntity enteredUser;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PriceTypeENUM getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceTypeENUM priceType) {
        this.priceType = priceType;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDate enteredDate) {
        this.enteredDate = enteredDate;
    }
}
