package com.cg.dealsdateonlinegiftshopping.service;



import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;

public interface UserServiceIntf {

	
	public User getProfile(int id) throws UserException;

	public User updateName(User user) throws UserException;

	public User updateMobileNo(User user) throws UserException;

}
