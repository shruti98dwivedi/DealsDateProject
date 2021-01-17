
package com.cg.dealsdateproductmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class DealsDateProductMicroserviceApplication extends SpringBootServletInitializer {
	

	public static void main(String[] args) {
		SpringApplication.run(DealsDateProductMicroserviceApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(DealsDateProductMicroserviceApplication.class);
	}

}
