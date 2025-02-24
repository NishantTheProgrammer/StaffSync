package com.programmer.StaffSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.service.CompanyService;


@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/company")
public class CompanyController {
    

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public Page<Company> getList(@PageableDefault(size = 10) Pageable pageable) {
        return this.companyService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable int id) {
        Optional<Company> company = this.companyService.getCompany(id);
        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
