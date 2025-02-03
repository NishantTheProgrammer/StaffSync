package com.programmer.StaffSync.entity;

import java.time.LocalDate;

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
    private User user;

    @ManyToOne
    private Company company;
}
