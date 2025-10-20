package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.dto.EmployeeDTO;
import com.my_projects.Tea_Manager.dto.LoginDTO;
import com.my_projects.Tea_Manager.dto.UserDTO;
import com.my_projects.Tea_Manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAPI {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){
        UserDTO save = userService.createUser(userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>(
                HttpStatus.CREATED.toString(),
                "User saved Successfully",
                save
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        //LoginDTO login =
        return null;
    }
}
