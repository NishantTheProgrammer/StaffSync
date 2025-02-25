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

import com.programmer.StaffSync.dto.CompanyDto;
import com.programmer.StaffSync.dto.RegisterUserDto;
import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.entity.Project;
import com.programmer.StaffSync.entity.Salary;
import com.programmer.StaffSync.entity.User;
import com.programmer.StaffSync.enums.UserRole;
import com.programmer.StaffSync.service.AuthenticationService;
import com.programmer.StaffSync.service.CompanyService;


@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/company")
public class CompanyController {
    

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AuthenticationService authenticationService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<Company> save(@RequestBody CompanyDto companyDto) {
        Company company;
        if(companyDto.getId() != null && companyDto.getId() > 0) {
            company = this.companyService.getCompany(companyDto.getId()).get();
        } else {
            company = new Company(companyDto);
            User user = this.authenticationService.signup(new RegisterUserDto(companyDto), UserRole.COMPANY);
            company.setUser(user);
        }
        Company savedCompany = this.companyService.save(company);
        return ResponseEntity.status(201).body(savedCompany); // Return saved proj
    }
}
