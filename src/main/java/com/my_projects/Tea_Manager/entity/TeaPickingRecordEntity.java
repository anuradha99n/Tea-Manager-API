package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tea_picking_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeaPickingRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @Column(nullable = false)
    private BigDecimal pickerAmount;
    @ManyToOne
    @JoinColumn(name = "entered_user_id", nullable = false)
    private EmployeeEntity enteredUser;

    @Column(nullable = false)
    private LocalDate enteredDate;

    @PrePersist
    protected void onCreate(){
        enteredDate = LocalDate.now();
    }

}
