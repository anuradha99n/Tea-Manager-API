package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String employeeId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDate joinedDate;
    @Column(nullable = false)
    private boolean active;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = true)
    private DesignationEntity designation;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private UserEntity user;

    public UserEntity getUser() { return user; }

    public boolean getIsActive() {
        return active;
    }


    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }
}
