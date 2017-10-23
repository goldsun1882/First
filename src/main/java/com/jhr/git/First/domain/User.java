package com.jhr.git.First.domain;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * data 注解提供所有的getter setter
 */

@Data
public class User implements Serializable{
    private String id;
    private String username;
    private String password;
}
