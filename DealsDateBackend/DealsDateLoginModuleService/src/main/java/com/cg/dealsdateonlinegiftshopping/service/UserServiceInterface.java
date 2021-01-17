package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;



public interface UserServiceInterface {

	User signUp(User user) throws UserException;

	Boolean deleteUser(int id) throws UserException;

	User findById(int id) throws UserException;

	User loginUser(String email, String password) throws UserException;

	User loginAdmin(String email, String password) throws UserException;

	User findByEmail(String email) throws UserException;

	String logout(User user, int id) throws UserException;

	String updatePassword(User user, int id) throws UserException;

	String updatePhoneNumber(User user, int id) throws UserException;

	String updateFullName(User user, int id) throws UserException;

	String updateUserToAdmin(User user, int id) throws UserException;

	List<User> getAllUsers();

	String updateToUser(User user, int id) throws UserException;

	String updateUser(User user, int id) throws UserException;




}
