package com.codeex.taskcode.service;

import com.codeex.taskcode.domain.dao.RoleRepository;
import com.codeex.taskcode.domain.dto.UserRoleAddDto;
import com.codeex.taskcode.domain.model.Role;
import com.codeex.taskcode.domain.model.UserRole;
import com.codeex.taskcode.domain.dao.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    final UserRoleRepository userRoleRepository;
    final RoleRepository roleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository, RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public List<UserRole> findByUserId(Integer userId) {
        return userRoleRepository.findByUserId(userId);
    }

    public void remove(UserRole userRole) {
        userRoleRepository.remove(userRole);
    }

    public void add(UserRoleAddDto userRoleAddDto) {
        Role role = roleRepository.findByName(userRoleAddDto.getRoleName());
        if (role == null)
            throw new RuntimeException("Role is not valid");
        else {
            UserRole userRole = new UserRole(userRoleAddDto.getUserId(), role.getId());
            userRoleRepository.add(userRole);
        }
    }

}
