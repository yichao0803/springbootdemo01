package com.bjgoodwill.springbootdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bjgoodwill.springbootdemo01.controller",
        "com.bjgoodwill.springbootdemo01.service"})
@MapperScan(basePackages = {"com.bjgoodwill.springbootdemo01.mapper"})
@SpringBootApplication
public class Springbootdemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo01Application.class, args);
    }

}
