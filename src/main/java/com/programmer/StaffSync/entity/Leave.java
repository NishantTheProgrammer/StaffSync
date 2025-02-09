package com.programmer.StaffSync.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.programmer.StaffSync.enums.LeaveType;

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
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private LocalDate date;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonIgnore
    private Employee actionBy;


    @JsonProperty("actionById")
    public Integer getActionById() {
        return actionBy != null ? actionBy.getId() : null;
    }

    public void setActionById(Integer actionById) {
        if (actionById != null) {
            Employee actionBy = new Employee();
            actionBy.setId(actionById);  // Set employee object based on actionById
            this.actionBy = actionBy;    // Set the Employee employee
        }
    }

    private Boolean isApproved;

    private String comment;

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
}
