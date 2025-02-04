package com.programmer.StaffSync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.programmer.StaffSync.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)  
    private TaskStatus status;


    @ManyToOne
    @JsonIgnore
    private User createdBy;

    @JsonProperty("createdById")
    public Integer getCreatedById() {
        return createdBy != null ? createdBy.getId() : null;
    }

    public void setCreatedById(Integer createdById) {
        if (createdById != null) {
            User createdBy = new User();
            createdBy.setId(createdById);  // Set createdBy object based on createdById
            this.createdBy = createdBy;    // Set the createdBy object
        }
    }

    
    @ManyToOne
    @JsonIgnore
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
