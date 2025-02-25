package com.programmer.StaffSync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.programmer.StaffSync.dto.CompanyDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    public Company(CompanyDto dto) {
        if(dto.getId() != null) {
            this.id = dto.getId();
        }
        this.name = dto.getName();
        this.logo = dto.getLogo();
        this.address = dto.getAddress();
        this.pan = dto.getPan();
    }

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
