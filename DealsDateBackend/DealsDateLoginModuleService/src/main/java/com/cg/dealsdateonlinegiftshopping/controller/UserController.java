package com.cg.dealsdateonlinegiftshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;
import com.cg.dealsdateonlinegiftshopping.service.UserServiceInterface;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServiceInterface userService;
	
	
	

	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserException {
		User use = userService.signUp(user);
		return new ResponseEntity<>(use, HttpStatus.OK);
	}
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.loginUser(email, password);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/admin/{email}/{password}")
	public ResponseEntity<User> admin(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.loginAdmin(email, password);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getAllUserDetails")
	public ResponseEntity<List<User>> getAllUserDetails() {
		List<User> lstUser = userService.getAllUsers();
		return new ResponseEntity<List<User>>(lstUser, HttpStatus.OK);
	}
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.findByEmail(email);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") int userId) throws UserException {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted", HttpStatus.OK);
	}
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<Object> getUserById(@PathVariable("userId") int userId) throws UserException {
		User user = userService.findById(userId);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") int userId, @RequestBody User user)
			throws UserException {
		User userr = userService.findById(userId);
		if (userr != null) {	
			String result = userService.updateUser(userr, userId);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/updateFullName/{userId}")
	public ResponseEntity<User> updateFullName(@PathVariable("userId") int userId, @RequestBody User updated)
			throws UserException {
		User user = userService.findById(userId);
		if (user != null) {	
			userService.updateFullName(updated, userId);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePassword/{userId}")
	public ResponseEntity<User> updatePassword(@PathVariable("userId") int userId, @RequestBody User user)
			throws UserException {
		User userr = userService.findById(userId);
		if (userr != null) {
			userService.updatePassword(user, userId);
		
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePhoneNumber/{userId}")
	public ResponseEntity<User> updatePhoneNumber(@PathVariable("userId") int userId, @RequestBody User user)
			throws UserException {
		User userr = userService.findById(userId);
		if (userr != null) {
			userService.updatePhoneNumber(user, userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateUserToAdmin/{userId}")
	public ResponseEntity<User> updateUserToAdmin(@PathVariable("userId") int userId, User user) throws UserException {
		User userr = userService.findById(userId);
		if (userr != null) {
			userService.updateUserToAdmin(user, userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateToUser/{userId}")
	public ResponseEntity<User> updateToUser(@PathVariable("userId") int userId, User user) throws UserException {
		User userr = userService.findById(userId);
		if (userr != null) {
			userService.updateToUser(user, userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/logout/{userId}")
	public ResponseEntity<String> logout(User user, @PathVariable("userId") int userId) throws UserException {
		User use = userService.findById(userId);
		if (use != null) {
			userService.logout(user,userId);
			return new ResponseEntity<>("Logged Out Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	
	
	
}
