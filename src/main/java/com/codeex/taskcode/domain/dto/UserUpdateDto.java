package com.codeex.taskcode.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    @NotNull
    @ApiModelProperty(required = true)
    private Integer id;
    @NotNull
    @ApiModelProperty(required = true)
    private String firstName;
    @NotNull
    @ApiModelProperty(required = true)
    private String lastName;
    @NotNull
    @ApiModelProperty(required = true)
    private String username;
}
