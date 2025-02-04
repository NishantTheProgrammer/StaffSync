package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Notification;
import com.programmer.StaffSync.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void add(Notification notification) {
        this.notificationRepository.save(notification);
    }

    public Page<Notification> getAll(Pageable pageable) {
        return this.notificationRepository.findAll(pageable);
    }

    public void save(Notification notification) {
        this.notificationRepository.save(notification);
    }


    public Optional<Notification> getByPk(Integer id) {
        return this.notificationRepository.findById(id);
    }
    
}
