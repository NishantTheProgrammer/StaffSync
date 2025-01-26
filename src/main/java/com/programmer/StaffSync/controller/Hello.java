package com.programmer.StaffSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.User;
import com.programmer.StaffSync.repository.UserRepository;

@RestController
public class Hello {


    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("hi")
    public String hi() {
        return "HI";
    }

    @GetMapping("/usertest") 
    public User getUser() {
        return this.userRepository.findByEmail("nishant@dhwaniris.com").get();
    }
}
