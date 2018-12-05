package com.pomelo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Mr.Jangni
 * @Description EnableEurekaClient 开启eureka客户端
 * EnableDiscoveryClient 同EnableEurekaClient一样 EnableEurekaClient只适用于EnableEurekaServer服务发现
 * EnableDiscoveryClient适用于EnableEurekaServer 同时也已用于其他的服务发现
 * @Date 2018/12/5 19:51
 **/
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
