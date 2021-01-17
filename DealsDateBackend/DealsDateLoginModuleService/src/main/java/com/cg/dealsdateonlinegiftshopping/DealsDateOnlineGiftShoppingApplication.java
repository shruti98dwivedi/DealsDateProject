package com.cg.dealsdateonlinegiftshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DealsDateOnlineGiftShoppingApplication{

	@Autowired
public static void main(String[] args) {
	SpringApplication.run(DealsDateOnlineGiftShoppingApplication.class, args);
}

}
