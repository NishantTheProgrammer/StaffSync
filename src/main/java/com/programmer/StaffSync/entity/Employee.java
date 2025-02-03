package com.programmer.StaffSync.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.programmer.StaffSync.enums.Role;

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
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long salary;
    private int experience;
    private LocalDate dateOfJoining;
    
    @Enumerated(EnumType.STRING)  // To store the role as a string in the database
    private Role role; 

    @ManyToOne
    private Employee manager;

    @ManyToOne
    @JsonIgnore
    private User user;

    @JsonProperty("userId")
    public Integer getUserId() {
        return user != null ? user.getId() : null;
    }

    public void setUserId(Integer userId) {
        if (userId != null) {
            User user = new User();
            user.setId(userId);  // Set user object based on userId
            this.user = user;    // Set the user object
        }
    }





    @ManyToOne
    @JsonIgnore
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
