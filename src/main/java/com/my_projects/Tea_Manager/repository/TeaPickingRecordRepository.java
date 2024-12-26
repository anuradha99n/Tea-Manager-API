package com.my_projects.Tea_Manager.repository;

import com.my_projects.Tea_Manager.dto.TeaPickingRecordDTO;
import com.my_projects.Tea_Manager.entity.TeaPickingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TeaPickingRecordRepository extends JpaRepository<TeaPickingRecordEntity, Long> {
    List<TeaPickingRecordDTO> findByEmployeeIdAndDateBetween(Long employee_id, LocalDateTime startDate, LocalDateTime endDate);
}
