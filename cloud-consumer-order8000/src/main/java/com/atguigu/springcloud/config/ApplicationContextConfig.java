package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    // commented @LoadBalanced if want to use self-implemented load balancer
    @LoadBalanced
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

}
