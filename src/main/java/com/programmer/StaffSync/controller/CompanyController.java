package com.programmer.StaffSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
    

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public List<Company> getCompanyList() {
        return this.companyService.getCompanyList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyList(@PathVariable int id) {
        Optional<Company> company = this.companyService.getCompany(id);
        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
