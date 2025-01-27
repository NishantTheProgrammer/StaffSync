package com.programmer.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmer.StaffSync.entity.Admin;
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
}
