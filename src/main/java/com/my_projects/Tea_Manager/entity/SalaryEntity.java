package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.SalaryStatusENUM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="salary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private BigDecimal totalPickedTea;
    @Column(nullable = false)
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SalaryStatusENUM status;
    @ManyToOne
    @JoinColumn(name = "price_per_kilo_id", nullable = false)
    private PricePerKiloEntity pricePerKilo;

    @ManyToOne
    @JoinColumn(name = "created_user_id", nullable = false)
    private EmployeeEntity createdUser;
    @Column(nullable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "approved_user_id", nullable = true)
    private EmployeeEntity approvedUser;
    @Column(nullable = true)
    private LocalDate approvedDate;

    @ManyToOne
    @JoinColumn(name = "paid_user_id")
    private EmployeeEntity paidUser;
    @Column(nullable = true)
    private LocalDate paidDate;

    @ManyToOne
    @JoinColumn(name = "rejected_user_id")
    private EmployeeEntity rejectedUser;
    @Column(nullable = true)
    private LocalDate rejectedDate;
    private String rejectedReason;

    @ManyToOne
    @JoinColumn(name = "updated_user_id")
    private EmployeeEntity updatedUser;
    @Column(nullable = true)
    private LocalDate updatedDate;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDate.now();
    }
}
