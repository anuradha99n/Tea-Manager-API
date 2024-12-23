package com.my_projects.Tea_Manager.dto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class TeaPickingRecordDTO {
    private Long id;
    private Long employee_id;
    private LocalDateTime entered_datetime;
    private BigDecimal kilos_picked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public LocalDateTime getEntered_datetime() {
        return entered_datetime;
    }

    public void setEntered_datetime(LocalDateTime entered_datetime) {
        this.entered_datetime = entered_datetime;
    }

    public BigDecimal getKilos_picked() {
        return kilos_picked;
    }

    public void setKilos_picked(BigDecimal kilos_picked) {
        this.kilos_picked = kilos_picked;
    }
}
