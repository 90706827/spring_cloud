package com.pomelo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Mr.Jangni
 * @Description 启动类
 * @Date 2018/12/5 20:42
 **/
@SpringBootApplication
@EnableEurekaClient
public class BasicServicesInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicServicesInfoApplication.class, args);
	}
}
