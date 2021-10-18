package com.codeex.taskcode.service;

import com.codeex.taskcode.domain.model.Role;
import com.codeex.taskcode.domain.dao.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleService {
    final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Integer id) {
        return roleRepository.findById(id);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public void remove(Integer id) {
        roleRepository.remove(id);
    }

    public void add(Role role) {
        roleRepository.add(role);
    }

    public Role update(Role role) {
        roleRepository.update(role);
        return roleRepository.findById(role.getId());
    }
}
