package com.cg.dealsdateonlinegiftshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dealsdateonlinegiftshopping.dao.UserDao;
import com.cg.dealsdateonlinegiftshopping.entity.User;

@SpringBootApplication
public class DealsDateOnlineGiftShoppingApplication implements CommandLineRunner {

	@Autowired
	private UserDao userRepo;
	
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("Sai Teja");
		user.setPassword("teja789");
		user.setMobileNumber(9493988466l);
		user.setGmailId("saiteja@gmail.com");
		userRepo.saveAndFlush(user);
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(DealsDateOnlineGiftShoppingApplication.class, args);
		
		
	}

}
