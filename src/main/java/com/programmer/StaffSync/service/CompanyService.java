package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanyList() {
        return this.companyRepository.findAll();
    }

    public Optional<Company> getCompany(int id) {
        return this.companyRepository.findById(id);
    }

}
