package com.programmer.StaffSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmer.StaffSync.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    
}
