package com.my_projects.Tea_Manager.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeaPickingRecordInputDTO {
    private String employeeId;
    private BigDecimal pickedAmount;
    private BigDecimal waterWeight;
    private BigDecimal bagWeight;
    private String enteredUserId;
}
