package com.cg.dealsdateonlinegiftshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.UserDao;
import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;


@Service
public class UserServiceImpl  implements UserServiceIntf{

	@Autowired
	private UserDao userRepo;
	@Override
	public User getProfile(int id) throws UserException {
		Optional<User> user = userRepo.findById(id);
		User userDetails = user.get();
		if(userDetails != null)
		{
			return userDetails;
		}
		throw new UserException("User Not Found");
	}

	@Override
	public User updateName(User user) throws UserException {
		if(userRepo.existsById(user.getUserId()))
		{
			Optional<User> tempUser = userRepo.findById(user.getUserId());
			User userDetails = tempUser.get();
			userDetails.setUserName(user.getUserName());
			userRepo.saveAndFlush(userDetails);
			return userDetails;
		}
		else
		{
		throw new UserException("userName cannot update");
		}
	}

	@Override
	public User updateMobileNo(User user) throws UserException {
		if(userRepo.existsById(user.getUserId()))
		{
			Optional<User> tempUser = userRepo.findById(user.getUserId());
			User userDetails = tempUser.get();
			userDetails.setMobileNumber(user.getMobileNumber());
			userRepo.saveAndFlush(userDetails);
			return userDetails;
		}
		throw new UserException("Mobile Number cannot be updated");
	}

}
