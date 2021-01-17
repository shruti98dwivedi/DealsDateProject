package com.cg.dealsdatecartmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@EnableFeignClients("com.cg.dealsdatecartmicroservice.service")
@SpringBootApplication

public class DealsDateCartMicroServiceApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(DealsDateCartMicroServiceApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(DealsDateCartMicroServiceApplication.class);
	}
}