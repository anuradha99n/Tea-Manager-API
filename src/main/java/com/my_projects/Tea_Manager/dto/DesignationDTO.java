package com.my_projects.Tea_Manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignationDTO {

    private String id;
    private String designationName;
    @JsonProperty("isActive")
    private boolean isActive;
    private LocalDate createdDate;
    private String createdBy;

    // Getters and Setters
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

}
