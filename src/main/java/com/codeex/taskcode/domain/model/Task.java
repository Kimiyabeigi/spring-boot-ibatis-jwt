package com.codeex.taskcode.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Integer id;
    private String subject;
    private Date dueDate;
    private Integer userId;

}
