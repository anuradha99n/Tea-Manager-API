package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Role")
public class RoleEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleId;
    @Column(nullable = false)
    private String roleName;
    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "created_user_id", nullable = false)
    private EmployeeEntity createdUser;
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "updated_user_id")
    private EmployeeEntity updatedUser;
    @Column(nullable = true)
    private LocalDate updatedDate;


    @PrePersist
    protected void onCreate(){

        createdDate = LocalDate.now();
        active = true;
    }


}
