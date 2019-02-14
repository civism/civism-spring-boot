package com.civism;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.civism.dao")
public class CivismSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CivismSpringBootApplication.class, args);
    }

}

