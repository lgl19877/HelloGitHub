package com.boot.datamybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.boot.datamybatis.mapper")
@SpringBootApplication
public class DatamybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatamybatisApplication.class, args);
    }
}
