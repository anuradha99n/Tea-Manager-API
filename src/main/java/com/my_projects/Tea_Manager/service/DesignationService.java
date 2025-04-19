package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.DesignationDTO;
import com.my_projects.Tea_Manager.entity.DesignationEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DesignationService {
    DesignationDTO createDesignation(DesignationDTO designationDTO);
    DesignationDTO getDesignationById(String id);
    List<DesignationDTO> updateDesignation(String id, DesignationDTO designationDTO);

    boolean deleteDesignation(String id);
}
