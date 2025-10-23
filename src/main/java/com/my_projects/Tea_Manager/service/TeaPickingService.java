package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.TeaPickingRecordInputDTO;

public interface TeaPickingService {
    public Boolean SaveTeaPickingRecord(TeaPickingRecordInputDTO dto);
}
