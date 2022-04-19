package com.springcloud.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Eureka 开启服务注册中心端
public class SpringcloudEureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka7002.class,args);
    }
}
