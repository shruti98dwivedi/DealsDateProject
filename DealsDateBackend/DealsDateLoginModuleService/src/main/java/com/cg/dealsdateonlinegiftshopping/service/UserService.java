package com.cg.dealsdateonlinegiftshopping.service;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.UserDao;
import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.entity.User.login;
import com.cg.dealsdateonlinegiftshopping.entity.User.type;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;



@Transactional
@Service("userService")
public class UserService implements UserServiceInterface {
 
	@Autowired
	private UserDao userDao;
	

	

	/************************************************************************************
	 * Method: 					signUp 
	 * Description: 			To register the User
	 * @param signUp:     		Registering the user for wallet
	 * @param checkEmail: 		check for the email if already exits
	 * @returns user: 			returns the user which is persisted
	 ************************************************************************************/

	@Override
	public User signUp(User user) throws UserException {
		checkEmail(user.getEmail());
		userDao.signUp(user);
		return user;
	}

	boolean checkEmail(String email) throws UserException {
		if (userDao.findUserByEmail(email))
			throw new UserException("User already exists, please login with your email");
		else
			return true;
	}
	

	/************************************************************************************
	 * Method:					login 
	 * Description: 			to login into the system by user or admin
	 * @param loginUser:  		login for user
	 * @param loginAdmin: 		login for admin
	 * @returns user: 			returns the user
	 ************************************************************************************/

	@Override
	public User loginUser(String email, String password) throws UserException {
		User user = userDao.getUserByEmail(email);
		if (userDao.findUserByEmail(email) == false)
			throw new UserException("User does not exist, Please enter a valid email!");
		if (user.getUserType() == type.admin)
			throw new UserException("Access denied, Only User can access!");
		if (user.getPassword().equals(password) == false)
			throw new UserException("The Username and Password does not match!");
		if (userDao.updateLogoutStatus(user, email) != true)
			throw new UserException("User is already LoggedIn!");
		return user;
	}

	@Override
	public User loginAdmin(String email, String password) throws UserException {
		User user = userDao.getUserByEmail(email);
		if (userDao.findUserByEmail(email) == false)
			throw new UserException("User does not exist, Please enter a valid email!");
		if (user.getUserType() == type.user)
			throw new UserException("Access denied, Only admin can access!");
		if (user.getPassword().equals(password) == false)
			throw new UserException("The Username and Password does not match!");
		if (userDao.updateLogoutStatus(user, email) != true)
			throw new UserException("Admin is already LoggedIn");
		return user;
	}

	/************************************************************************************
	 * Method: 					getAllUsers 
	 * Description: 			It gets all the details of users as well as admin 
	 * @param getAllUsers: 		fetches the user details
	 * @returns user: 			returns the user details
	 ************************************************************************************/

	@Override
	public List<User> getAllUsers() {
		return userDao.getUserAndAdminDetails();
	}

	/************************************************************************************
	 * Method: 					deleteUser 
	 * Description: 			It is admin process which deletes the user by id
	 * @param deleteUser: 		deletes the user
	 * @returns boolean: 		returns user id
	 ************************************************************************************/

	@Override
	public Boolean deleteUser(int id) throws UserException {
		if (userDao.findById(id) == null) {
			throw new UserException("User does not exist");
		}
		return userDao.deleteUser(id);
	}

	/************************************************************************************
	 * Method:					find 
	 * Description: 			it finds the user from User.class
	 * @param findById:   		fetches the details by id
	 * @param findByEmail 		fetches the details by email
	 * @returns id: 			returns the user
	 ************************************************************************************/

	@Override
	public User findById(int id) throws UserException {
		if (userDao.findById(id) == null) {
			throw new UserException("User does not exist");
		}
		return userDao.findById(id);
	}

	@Override
	public User findByEmail(String email) throws UserException {
		if (userDao.findUserByEmail(email) == false)
			throw new UserException("User does not exist, Please signUp!");
		return userDao.getUserByEmail(email);
	}

	/************************************************************************************
	 * Method: 					update 
	 * Description: 			it updates the details of user
	 * @param updateFullName:    updates fullname
	 * @param updatePassword:    updates password
	 * @param updatePhoneNumber: updates phoneNumber
	 * @param updateUserToAdmin: updates user status to admin
	 * @param updateToUser:      updates status to user
	 * @param logout:            update the login status to logout
	 * @returns exception:		 returns String value and exception
	 ************************************************************************************/
	
	@Override
	public String updateUser(User user, int id) throws UserException {
		if (userDao.updateUser(user, id))
			return "User Details Updated";
		else
			throw new UserException("Error updating Name");
	}
	@Override
	public String updateFullName(User user, int id) throws UserException {
		if (userDao.updateFullName(user, id))
			return "Name Updated";
		else
			throw new UserException("Error updating Name");
	}

	@Override
	public String updatePassword(User user, int id) throws UserException {
		if (userDao.updatePassword(user, id))
			return "Password Updated";
		else
			throw new UserException("Error updating Password");
	}

	@Override
	public String updatePhoneNumber(User user, int id) throws UserException {
		if (userDao.updatePhoneNumber(user, id))
			return "PhoneNumber Updated";
		else
			throw new UserException("Error updating PhoneNumber");
	}

	@Override
	public String updateUserToAdmin(User user, int id) throws UserException {
		if (userDao.updateUserToAdmin(user, id))
			return " Updated";
		else
			throw new UserException("Error updating status");
	}

	@Override
	public String updateToUser(User user, int id) throws UserException {
		if (userDao.updateToUser(user, id))
			return " Updated";
		else
			throw new UserException("Error updating status");
	}

	@Override
	public String logout(User user, int id) throws UserException {
		if (userDao.updateLoginStatus(user, id) != true)
			throw new UserException("User already LoggedOut");
		else
			return "LoggedOut";
	}
	
}