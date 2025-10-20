package com.my_projects.Tea_Manager.dto;

import com.my_projects.Tea_Manager.enums.RoleENUM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String userName;
    private boolean isActive;
    private String roleId;
    private String employeeId;
    private String password;

    // Getters and Setters

}
