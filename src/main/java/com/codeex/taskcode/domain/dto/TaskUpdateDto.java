package com.codeex.taskcode.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateDto {
    @NotNull
    @ApiModelProperty(required = true)
    private Integer id;
    @NotNull
    @ApiModelProperty(required = true)
    private String subject;
    @NotNull
    @ApiModelProperty(required = true)
    private Date dueDate;

}
