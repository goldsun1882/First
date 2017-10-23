package com.jhr.git.First.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * data 注解提供所有的getter setter
 */

@Data
@ToString(exclude = "password")
@ApiModel("用户对象")
public class User implements Serializable{
    @ApiModelProperty(value = "用户编号", required = true)
    private String id;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
