package com.codeex.taskcode.controller;

import com.codeex.taskcode.domain.dto.UserAddDto;
import com.codeex.taskcode.domain.dto.UserUpdateDto;
import com.codeex.taskcode.domain.model.User;
import com.codeex.taskcode.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserAddDto userAddDto) {
        return ResponseEntity.ok(userService.add(userAddDto));
    }

    @PutMapping ResponseEntity<User> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok().body(userService.update(userUpdateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Integer id) {
        userService.remove(id);
        return ResponseEntity.ok().build();
    }

}
