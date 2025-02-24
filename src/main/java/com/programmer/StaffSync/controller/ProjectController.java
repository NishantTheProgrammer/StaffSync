package com.programmer.StaffSync.controller;

import java.util.List;
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

import com.programmer.StaffSync.entity.Project;
import com.programmer.StaffSync.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('COMPANY')")
    @GetMapping("")
    public Page<Project> getList(@PageableDefault(size = 10) Pageable pageable) {
        return this.projectService.getAll(pageable);
    }

    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('COMPANY')")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id) {
        Optional<Project> project = this.projectService.getByPk(id);
        if(project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PreAuthorize("hasRole('COMPANY')")
    @PostMapping("")
    public ResponseEntity<Project> save(@RequestBody Project project) {
        Project savedProject = this.projectService.save(project);
        return ResponseEntity.status(201).body(savedProject); // Return saved project with 201 Created
    }
}
