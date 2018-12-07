package com.pomelo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerBackupApplication.class, args);
	}
}
