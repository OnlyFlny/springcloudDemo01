package com.springcloud.crowd;

import com.netflix.discovery.EurekaNamespace;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // 将服务的提供者或者消费者自动注入到在Eureka注册中心
@SpringBootApplication
@MapperScan("com.springcloud.crowd.mapper")
public class ApplicationStarter8001 {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationStarter8001.class,args);

    }

}