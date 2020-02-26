package com.hz.readapple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.hz.service","com.hz.controller"})//组件扫描
@MapperScan("com.hz.mapper")//映射扫描
@EnableCaching  //开启缓存
@SpringBootApplication//开启SpringBoot应用注解
@EnableScheduling//启用调度
public class ReadappleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadappleApplication.class, args);
    }

}
