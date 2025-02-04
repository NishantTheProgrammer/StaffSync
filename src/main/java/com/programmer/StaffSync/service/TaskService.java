package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Task;
import com.programmer.StaffSync.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Page<Task> getAll(Pageable pageable) {
        return this.taskRepository.findAll(pageable);
    }

    public Optional<Task> findByPk(Integer id) {
        return this.taskRepository.findById(id);
    }

    public Task save(Task task) {
        return this.taskRepository.save(task);
    }
}
