package com.programmer.StaffSync.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Leave;
import com.programmer.StaffSync.repository.LeaveRepository;

@Service
public class LeaveService {
    
    @Autowired
    private LeaveRepository leaveRepository;


    public Page<Leave> getAll(Pageable pageable) {
        return this.leaveRepository.findAll(pageable);
    }

    public Optional<Leave> findByPk(Integer id) {
        return this.leaveRepository.findById(id);
    }

    public Leave save(Leave leave) {
        return this.leaveRepository.save(leave);
    }
}
