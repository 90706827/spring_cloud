package com.pomelo.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerProviderInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProviderInfoApplication.class, args);
	}
}
