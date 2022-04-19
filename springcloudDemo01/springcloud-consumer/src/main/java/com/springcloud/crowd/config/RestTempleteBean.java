package com.springcloud.crowd.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempleteBean {

    @Bean
    @LoadBalanced //配置负载均衡下实现RestTemplete
    public RestTemplate getRestTemplete(){
        return new RestTemplate();
    }
}
