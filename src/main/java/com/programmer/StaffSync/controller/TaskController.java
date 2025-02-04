package com.programmer.StaffSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.StaffSync.entity.Task;
import com.programmer.StaffSync.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("")
    public Page<Task> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return this.taskService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findByPk(@PathVariable Integer id) {
        Optional<Task> task = this.taskService.findByPk(id);

        if(task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Task save(@RequestBody Task task) {
        return this.taskService.save(task);
    }

    
}
