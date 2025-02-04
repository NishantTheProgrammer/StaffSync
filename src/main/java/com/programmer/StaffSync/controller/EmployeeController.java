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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.Employee;
import com.programmer.StaffSync.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public Page<Employee> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return this.employeeService.getAll(pageable);    
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Optional<Employee> employee =  this.employeeService.getByPk(id);
        
        if(employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
}
