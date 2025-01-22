package com.programmer.StaffSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
