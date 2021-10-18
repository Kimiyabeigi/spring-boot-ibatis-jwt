package com.codeex.taskcode.controller;

import com.codeex.taskcode.domain.dto.UserRoleAddDto;
import com.codeex.taskcode.domain.model.UserRole;
import com.codeex.taskcode.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user-role")
public class UserRoleController {
    final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<Void> addUserRole(@Valid @RequestBody UserRoleAddDto userRoleAddDto) {
        userRoleService.add(userRoleAddDto);
        return ResponseEntity.ok().build();
    }
}
