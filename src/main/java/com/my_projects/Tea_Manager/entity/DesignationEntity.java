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
    private String designationId;

    @Column(nullable = false, length = 100)
    private String designationName;
    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private String createdUserId;

    @Column(nullable = false)
    private LocalDate createdDate;

//    @ManyToOne
//    @JoinColumn(name = "created_user_id", nullable = false)
//    private UserEntity createdUser;


    public boolean getIsActive() {
        return active;
    }

    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

}
