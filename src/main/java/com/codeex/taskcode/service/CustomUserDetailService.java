package com.codeex.taskcode.service;

import com.codeex.taskcode.domain.model.Role;
import com.codeex.taskcode.domain.model.User;
import com.codeex.taskcode.domain.model.UserRole;
import com.codeex.taskcode.domain.dao.RoleRepository;
import com.codeex.taskcode.domain.dao.UserRepository;
import com.codeex.taskcode.domain.dao.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final UserRoleRepository userRoleRepository;

    public CustomUserDetailService(UserRepository userRepository, RoleRepository roleRepository,
                                   UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("No user found with username ".concat(username));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());

        for (UserRole userRole : userRoles) {
            Role role = roleRepository.findById(userRole.getRoleId());
            grantedAuthorities.add(
                    new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities);
    }
}
