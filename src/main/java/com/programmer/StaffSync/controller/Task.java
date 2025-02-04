package com.programmer.StaffSync.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.programmer.StaffSync.entity.Company;
import com.programmer.StaffSync.entity.Project;
import com.programmer.StaffSync.entity.User;
import com.programmer.StaffSync.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private TaskStatus status;


    @ManyToOne
    private User createdBy;

    
    @ManyToOne
    private Project project;

    @JsonProperty("projectId")
    public Integer getProjectId() {
        return project != null ? project.getId() : null;
    }

    public void setProjectId(Integer projectId) {
        if (projectId != null) {
            Project project = new Project();
            project.setId(projectId);  // Set project object based on projectId
            this.project = project;    // Set the project object
        }
    }
}
