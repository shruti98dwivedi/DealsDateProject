package com.cg.dealsdatediscoverymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DealsDateDiscoveryMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealsDateDiscoveryMicroservicesApplication.class, args);
	}

}
