package com.zwy.boot05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zwy.boot05.mapper")
@SpringBootApplication
public class Boot05Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot05Application.class, args);
    }

}
