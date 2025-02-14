package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(UUID id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UUID id, UserDTO userDTO);

    boolean deleteUser(UUID id);
}
