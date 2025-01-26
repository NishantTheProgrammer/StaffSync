package com.programmer.StaffSync.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}
