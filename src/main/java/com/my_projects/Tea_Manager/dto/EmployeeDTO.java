package com.my_projects.Tea_Manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String id;
    private String name;
    private String contact;
    private LocalDate joinedDate;
    private boolean isActive;
    private String address;
    private String designationId;

    private DesignationDTO designation;

    // Getters and Setters

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
