package com.springcloud.crowd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard// 开启服务监控
public class DashboardApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplicationStarter.class,args);
    }
}
