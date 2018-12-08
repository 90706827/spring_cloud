package com.pomelo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProviderUserApplication.class, args);
	}
}
