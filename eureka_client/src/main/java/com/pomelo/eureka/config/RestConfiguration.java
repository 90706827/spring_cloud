package com.pomelo.eureka.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestConfiguration
 * @Description Rest模板负责均衡
 * @Author Mr.Jangni
 * @Date 2018/12/5 22:27
 * @Version 1.0
 **/
@Configuration
public class RestConfiguration {

    /**
     * @Author Mr.Jangni
     * @Description LoadBalanced Rest模板作为负载均衡器客户端
     * @Date 2018/12/5 20:56
     **/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}