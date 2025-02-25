package com.programmer.StaffSync.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Page<Company> findAll(Pageable pageable) {
        return this.companyRepository.findAll(pageable);
    }

    public Optional<Company> getCompany(int id) {
        return this.companyRepository.findById(id);
    }

    public Company save(Company company) {
        return this.companyRepository.save(company);
    }
}
