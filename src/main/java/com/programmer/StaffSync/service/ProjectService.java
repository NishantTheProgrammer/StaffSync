package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Project;
import com.programmer.StaffSync.repository.ProjectRepository;

import jakarta.persistence.EntityManager;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    
    
    public void add(Project notification) {
        this.projectRepository.save(notification);
    }

    public Page<Project> getAll(Pageable pageable) {
        return this.projectRepository.findAll(pageable);
    }

    public Project save(Project notification) {
        return this.projectRepository.save(notification);
    }


    public Optional<Project> getByPk(Integer id) {
        return this.projectRepository.findById(id);
    }
}
