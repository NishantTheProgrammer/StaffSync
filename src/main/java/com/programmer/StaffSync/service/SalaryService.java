package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Salary;
import com.programmer.StaffSync.repository.SalaryRepository;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public Page<Salary> getAll(Pageable pageable) {
        return this.salaryRepository.findAll(pageable);
    }

    public Optional<Salary> getById(Integer id) {
        return this.salaryRepository.findById(id);
    }

    public Salary save(Salary salary) {
        return this.salaryRepository.save(salary);
    }
}
