package com.programmer.StaffSync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Company {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable =  false)
    private String name;
    private String logo;
    private String address;
    private String pan;


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

    
}
