package com.my_projects.Tea_Manager.service;

import com.my_projects.Tea_Manager.dto.TeaPickingRecordDTO;

public interface TeaPickingRecordService {
    TeaPickingRecordDTO save(TeaPickingRecordDTO teaPickingRecordDTO);
    TeaPickingRecordDTO get(Long id);
    void delete(Long id);
    TeaPickingRecordDTO update(TeaPickingRecordDTO teaPickingRecordDTO);
}
