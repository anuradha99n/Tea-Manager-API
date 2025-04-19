package com.my_projects.Tea_Manager.entity;

import com.my_projects.Tea_Manager.enums.RoleENUM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


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
    @Column(nullable = false)
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private RoleENUM roleId;
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    public String getPassword() {
        return password;
    }

    public boolean getIActive() {
        return isActive;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

}
