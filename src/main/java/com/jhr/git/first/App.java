package com.jhr.git.first;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author jinhuari
 */
@SpringBootApplication
@EnableCaching
@MapperScan({"com.jhr.git.**.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

