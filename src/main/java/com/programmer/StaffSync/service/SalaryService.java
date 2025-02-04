package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Salary;
import com.programmer.StaffSync.repository.SalaryRepository;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> getAll() {
        return this.salaryRepository.findAll();
    }

    public Optional<Salary> getById(Integer id) {
        return this.salaryRepository.findById(id);
    }

    public Salary save(Salary salary) {
        return this.salaryRepository.save(salary);
    }
}
