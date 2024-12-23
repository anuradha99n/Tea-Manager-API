package com.my_projects.Tea_Manager.repository;

import com.my_projects.Tea_Manager.entity.TeaPickingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaPickingRecordRepository extends JpaRepository<TeaPickingRecordEntity, Long> {
}
