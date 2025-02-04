package com.programmer.StaffSync.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.entity.Task;
import com.programmer.StaffSync.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }

    public Optional<Task> findByPk(Integer id) {
        return this.taskRepository.findById(id);
    }

    public Task save(Task task) {
        return this.taskRepository.save(task);
    }
}
