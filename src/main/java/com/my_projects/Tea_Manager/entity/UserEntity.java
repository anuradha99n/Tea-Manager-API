package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.RoleENUM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true, length = 50)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(name = "is_active",nullable = false)
    private boolean active;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private EmployeeEntity employee;

    public String getPassword() {
        return password;
    }

    public boolean getIsActive() {
        return active;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

}
