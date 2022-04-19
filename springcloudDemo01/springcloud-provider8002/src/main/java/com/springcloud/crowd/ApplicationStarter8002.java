package com.springcloud.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // 将服务的提供者或者消费者自动注入到在Eureka注册中心
@SpringBootApplication
@MapperScan("com.springcloud.crowd.mapper")
public class ApplicationStarter8002 {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationStarter8002.class,args);
    }
}