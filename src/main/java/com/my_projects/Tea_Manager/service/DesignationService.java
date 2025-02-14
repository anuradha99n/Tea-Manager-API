package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.DesignationDTO;
import com.my_projects.Tea_Manager.entity.DesignationEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DesignationService {
    DesignationDTO createDesignation(DesignationDTO designationDTO);
    DesignationDTO getDesignationById(UUID id);
    List<DesignationDTO> updateDesignation(UUID id, DesignationDTO designationDTO);

    boolean deleteDesignation(UUID id);
}
