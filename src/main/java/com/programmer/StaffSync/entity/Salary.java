package com.programmer.StaffSync.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Salary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate paymentDate;
    private long senderAcNumber;
    private long receiverAcNumber;
    private long amount;

    @ManyToOne
    @JsonIgnore
    private Employee employee;

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employee != null ? employee.getId() : null;
    }

    public void setEmployeeId(Integer employeeId) {
        if (employeeId != null) {
            Employee employee = new Employee();
            employee.setId(employeeId);  // Set employee object based on employeeId
            this.employee = employee;    // Set the Employee employee
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
