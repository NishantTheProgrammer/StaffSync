package com.programmer.StaffSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.Salary;
import com.programmer.StaffSync.service.SalaryService;


@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    
    @GetMapping("")
    public Page<Salary> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return this.salaryService.getAll(pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Salary> findById(@PathVariable int id) {
        Optional<Salary> salary = this.salaryService.getById(id);
        if(salary.isPresent()) {
            return ResponseEntity.ok(salary.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Salary save(@RequestBody Salary salary) {
        return this.salaryService.save(salary);
    }
}
