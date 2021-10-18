package com.codeex.taskcode;

import com.codeex.taskcode.domain.model.Role;
import com.codeex.taskcode.domain.model.Task;
import com.codeex.taskcode.domain.model.User;
import com.codeex.taskcode.domain.model.UserRole;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Deque;
import java.util.LinkedList;

@MapperScan("com.codeex.taskcode")
@MappedTypes({Task.class, User.class, Role.class, UserRole.class})
@SpringBootApplication
public class TaskCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskCodeApplication.class, args);
    }

}
