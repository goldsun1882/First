package com.jhr.git.first.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author jinhuari
 * date: 2017/12/5
 */
public class Response<T> {

    @ApiModelProperty("响应编码，成功：0")
    @Getter
    private String code;

    @ApiModelProperty("响应描述，成功：OK")
    @Getter
    private String message;

    @ApiModelProperty("包含实体")
    @Getter
    private T info;

    public static Response successResponse(){
        return new Response();
    }

}
