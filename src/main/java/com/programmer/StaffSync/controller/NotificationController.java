package com.programmer.StaffSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.Notification;
import com.programmer.StaffSync.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    
    @Autowired
    private  NotificationService notificationService;

    @GetMapping("")
    public ResponseEntity<List<Notification>> get() {
        return ResponseEntity.ok(this.notificationService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Notification> findById(@PathVariable int id) {
        Optional<Notification> nOptional = this.notificationService.getByPk(id);

        if(nOptional.isPresent()) {
            return ResponseEntity.ok().body(nOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Notification notification) {
        this.notificationService.save(notification);
        return ResponseEntity.ok().body("Notification saved");
    }
}
