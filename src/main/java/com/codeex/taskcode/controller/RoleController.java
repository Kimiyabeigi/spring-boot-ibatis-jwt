package com.codeex.taskcode.controller;

import com.codeex.taskcode.domain.model.Role;
import com.codeex.taskcode.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {
    final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(roleService.findById(id));
    }

    @GetMapping("{name}")
    public ResponseEntity<Role> getTaskByName(@PathVariable String name) {
        return ResponseEntity.ok().body(roleService.findByName(name));
    }

}
