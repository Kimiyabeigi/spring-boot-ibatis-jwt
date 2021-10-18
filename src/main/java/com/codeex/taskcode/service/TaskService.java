package com.codeex.taskcode.service;

import com.codeex.taskcode.domain.dao.TaskRepository;
import com.codeex.taskcode.domain.dto.TaskAddDto;
import com.codeex.taskcode.domain.dto.TaskUpdateDto;
import com.codeex.taskcode.domain.model.Task;
import com.codeex.taskcode.domain.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {
    final TaskRepository taskRepository;
    final UserRepository userRepository;
    final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<Task> findAll() {
        return taskRepository.findAll(getCurrentUserId());
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id, getCurrentUserId());
    }

    public void remove(Integer id) {
        Integer currentUserId = getCurrentUserId();
        checkTaskPermission(id, currentUserId);
        taskRepository.remove(id, currentUserId);
    }

    public Task add(TaskAddDto taskAddDto) {
        log.info("Create a new task: {}", taskAddDto);
        Task task = modelMapper.map(taskAddDto, Task.class);
        Integer currentUserId = getCurrentUserId();
        task.setUserId(currentUserId);
        taskRepository.add(task);
        return taskRepository.findLastTask(currentUserId);
    }

    public Task update(TaskUpdateDto taskUpdateDto) {
        Task task = modelMapper.map(taskUpdateDto, Task.class);
        Integer currentUserId = getCurrentUserId();
        task.setUserId(currentUserId);
        checkTaskPermission(task.getId(), currentUserId);
        taskRepository.update(task);
        return taskRepository.findById(task.getId(), currentUserId);
    }

    private void checkTaskPermission(Integer taskId, Integer userId) {
        if (taskRepository.findById(taskId, userId) == null)
            throw new RuntimeException("This task is not yours");
    }

    private Integer getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Optional<String> username = Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
        if (username.isPresent())
            return userRepository.findByUsername(username.get()).getId();
        else
            throw new RuntimeException("Current user is missing");
    }
}
