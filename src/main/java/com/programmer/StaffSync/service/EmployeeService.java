package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Employee;
import com.programmer.StaffSync.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    public Optional<Employee> getByPk(Integer id) {
        return this.employeeRepository.findById(id);
    }
}
