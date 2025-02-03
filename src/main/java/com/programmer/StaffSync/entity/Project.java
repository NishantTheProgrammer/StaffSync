package com.programmer.StaffSync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String ownerName;

    @ManyToOne
    private Company company;

    @JsonProperty("companyId")
    public Integer getCompanyId() {
        return company != null ? company.getId() : null;
    }

    public void setCompanyId(Integer companyId) {
        if (companyId != null) {
            Company company = new Company();
            company.setId(companyId);  // Set company object based on companyId
            this.company = company;    // Set the Company object
        }
    }
}
