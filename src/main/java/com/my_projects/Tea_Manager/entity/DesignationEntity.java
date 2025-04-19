package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "designation")
public class DesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 100)
    private String designationName;
    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDate createdDate;

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
