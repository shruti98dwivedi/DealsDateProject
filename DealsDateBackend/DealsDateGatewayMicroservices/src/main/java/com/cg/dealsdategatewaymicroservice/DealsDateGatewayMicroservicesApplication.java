package com.cg.dealsdategatewaymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class DealsDateGatewayMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealsDateGatewayMicroservicesApplication.class, args);
	}

}
