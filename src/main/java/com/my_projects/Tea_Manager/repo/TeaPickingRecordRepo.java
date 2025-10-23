package com.my_projects.Tea_Manager.repo;

import com.my_projects.Tea_Manager.entity.TeaPickingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaPickingRecordRepo extends JpaRepository<TeaPickingRecordEntity, String> {

}
