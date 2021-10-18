package com.codeex.taskcode.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAddDto {
    @NotNull
    @ApiModelProperty(required = true)
    private Integer userId;
    @NotNull
    @ApiModelProperty(required = true)
    private String roleName;
}
