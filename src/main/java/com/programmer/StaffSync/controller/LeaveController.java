package com.programmer.StaffSync.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.Leave;
import com.programmer.StaffSync.service.LeaveService;

@RestController
@PreAuthorize("hasRole('EMPLOYEE') || hasRole('COMPANY')")
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("")
    public Page<Leave> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return this.leaveService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leave> findByPk(@PathVariable Integer id) {
        Optional<Leave> leave = this.leaveService.findByPk(id);
        if(leave.isPresent()) {
            return ResponseEntity.ok(leave.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("")
    public Leave save(@RequestBody Leave leave) {
        return this.leaveService.save(leave);
    }
    
}
