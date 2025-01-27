package com.programmer.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmer.StaffSync.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
}
