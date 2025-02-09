package com.programmer.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmer.StaffSync.entity.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    
} 
