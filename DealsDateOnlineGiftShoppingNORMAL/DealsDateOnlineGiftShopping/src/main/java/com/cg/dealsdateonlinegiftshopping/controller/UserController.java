package com.cg.dealsdateonlinegiftshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.service.UserServiceIntf;

@RestController
@RequestMapping("/usersettings")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	private UserServiceIntf userService;
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id)
	{
		User user = userService.getProfile(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);	
	}
	

	
	@PutMapping("/updateusername/")
	public ResponseEntity<User> updateUserName(@RequestBody User user)
	{
		User profile = userService.updateName(user);
		return new ResponseEntity<User>(profile, HttpStatus.OK);
	}
	
	
	@PutMapping("/updateUsermobileno")
	public ResponseEntity<User> updateUserMobileNo(@RequestBody User user)
	{
		User profile = userService.updateMobileNo(user);
		return new ResponseEntity<User>(profile, HttpStatus.OK);
	}
}
