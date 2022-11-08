package com.ideas2it.training.dao;

import com.ideas2it.training.model.LeaveRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRecordsDao extends JpaRepository<LeaveRecords,Integer> {
    
}