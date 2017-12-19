package com.jhr.git.first.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * data 注解提供所有的getter setter
 * @author Administrator
 */

@Data
@ToString(exclude = "password")
@ApiModel("用户对象")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserReq implements Serializable{
    @ApiModelProperty(value = "用户编号", required = true)
    private String id;

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "银川分行价格", required = true)
    private String money;
}
