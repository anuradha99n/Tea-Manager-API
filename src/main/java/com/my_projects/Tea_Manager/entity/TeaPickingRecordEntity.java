package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tea_picking_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeaPickingRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String teaPickingRecordId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @Column(nullable = false)
    private BigDecimal pickedAmount;
    @Column(nullable = false)
    private BigDecimal waterWeight;
    @Column(nullable = false)
    private BigDecimal bagWeight;
    @ManyToOne
    @JoinColumn(name = "entered_user_id", nullable = false)
    private UserEntity enteredUser;

    @Column(nullable = false)
    private LocalDateTime enteredDateTime;

    @PrePersist
    protected void onCreate(){
        enteredDateTime = LocalDateTime.now();
    }

}
