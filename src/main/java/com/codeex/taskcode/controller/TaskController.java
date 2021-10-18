package com.codeex.taskcode.controller;

import com.codeex.taskcode.domain.dto.TaskAddDto;
import com.codeex.taskcode.domain.dto.TaskUpdateDto;
import com.codeex.taskcode.domain.model.Task;
import com.codeex.taskcode.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@Valid @RequestBody TaskAddDto taskAddDto) {
        return ResponseEntity.ok(taskService.add(taskAddDto));
    }

    @PutMapping ResponseEntity<Task> updateTask(@Valid @RequestBody TaskUpdateDto taskUpdateDto) {
        return ResponseEntity.ok().body(taskService.update(taskUpdateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeTasks(@PathVariable Integer id) {
        taskService.remove(id);
        return ResponseEntity.ok().build();
    }
}
