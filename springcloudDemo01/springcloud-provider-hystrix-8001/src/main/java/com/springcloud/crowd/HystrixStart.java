package com.springcloud.crowd;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient // 将服务的提供者或者消费者自动注入到在Eureka注册中心
@SpringBootApplication
@MapperScan("com.springcloud.crowd.mapper")
@EnableCircuitBreaker
public class HystrixStart {
    public static void main(String[] args) {

        SpringApplication.run(HystrixStart.class,args);
    }
    /*
     *  增加一个 servlet Bean 来提供服务监控，写法固定new HystrixMetricsStreamServlet()
     * */

    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean =
                new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");// 固定为豪猪页面的url
        return servletRegistrationBean;
    }
}