package com.programmer.StaffSync.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalDate readDate;
    private String content;

    @ManyToOne
    private User user;

    @JsonProperty("userId") // Serialize only the userId
    public Integer getUserId() {
        return user != null ? user.getId() : null;
    }
}
