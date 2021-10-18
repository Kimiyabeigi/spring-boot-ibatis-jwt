package com.codeex.taskcode.service;

import com.codeex.taskcode.domain.dto.UserAddDto;
import com.codeex.taskcode.domain.dto.UserUpdateDto;
import com.codeex.taskcode.domain.model.User;
import com.codeex.taskcode.domain.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    public void remove(Integer id){
        userRepository.remove(id);
    }

    public User add(UserAddDto userAddDto) {
        log.info("Create a new user: {}", userAddDto);
        User user = modelMapper.map(userAddDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.add(user);
        return findByUsername(userAddDto.getUsername());
    }

    public User update(UserUpdateDto userUpdateDto) {
        User user = modelMapper.map(userUpdateDto, User.class);
        userRepository.update(user);
        return userRepository.findById(user.getId());
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
