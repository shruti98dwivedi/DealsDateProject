package com.cg.dealsdateonlinegiftshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.entity.User.login;
import com.cg.dealsdateonlinegiftshopping.entity.User.type;

@Repository("userDao")
public class UserDaoImplementation implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	/************************************************************************************
	 * Method:                        signUp
	 * Description:                   To register the User 
	 * @param signUp				  Registering the user for wallet
	 * @returns user                  returns the user which is persisted 
	 ************************************************************************************/
	@Override
	public User signUp(User user) {
		entityManager.persist(user);
		return user;
	}
	/************************************************************************************
	 * Method:                        getUserAndAdminDetails
	 * Description:                   It gets all the details of users as well as admin 
	 * @param getUserAndAdminDetails  fetches the details
	 * @returns user                  returns the user details  
	 ************************************************************************************/
	
	@Override
	public List<User> getUserAndAdminDetails() {
		String Qstr = "SELECT user FROM User user";
		TypedQuery<User> query = entityManager.createQuery(Qstr, User.class);
		return query.getResultList();
	}
	/************************************************************************************
	 * Method:                        findUserByEmail
	 * Description:                   It finds the details of users as well as admin 
	 * @param findUserByEmail		  Fetches the details
	 * @returns boolean               returns true if user exists  
	 ************************************************************************************/
	
	@Override
	public boolean findUserByEmail(String email) {
		String Qstr = "SELECT user.email FROM User user WHERE user.email= :email";
		TypedQuery<String> query = entityManager.createQuery(Qstr, String.class).setParameter("email", email);
		try {
			query.getSingleResult();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	/************************************************************************************
	 * Method:                        getUserByEmail
	 * Description:                   It gets all the details of particular users as well as admin 
	 * @param getUserByEmail		  Fetches the details
	 * @returns user                  returns the user details  
	 ************************************************************************************/
	
	@Override
	public User getUserByEmail(String email) {
		String Qstr = "SELECT user FROM User user WHERE user.email= :email";
		TypedQuery<User> query = entityManager.createQuery(Qstr, User.class).setParameter("email", email);
		return query.getSingleResult();
	}
	/************************************************************************************
	 * Method:                        deleteUser
	 * Description:                   It is admin process which deletes the user by id 
	 * @param deleteUser			  deletes the user 
	 * @returns boolean               returns true or false
	 ************************************************************************************/
	
	@Override
	public Boolean deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityManager.remove(user);
			return true;
		}
		return false;
	}
	/************************************************************************************
	 * Method:                        findById
	 * Description:                   it finds the user from User.class 
	 * @param findById				  fetches the details
	 * @returns id                    returns the id 
	 ************************************************************************************/
	
	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}
	/************************************************************************************
	 * Method:                        update
	 * Description:                   it updates the details of user
	 * @param updateFullName		  updates fullname
	 * @param updatePassword		  updates password
	 * @param updatePhoneNumber		  updates phoneNumber
	 * @param updateUserToAdmin		  updates user status to admin
	 * @param updateToUser		  	  updates status to user
	 * @returns true                  returns true 
	 ************************************************************************************/
	@Override
	public boolean updateUser(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setFirstname(user.getFirstname());
		userUpdate.setLastname(user.getLastname());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setConfirmPassword(user.getConfirmPassword());
		userUpdate.setPhoneNumber(user.getPhoneNumber());
		entityManager.persist(userUpdate);
		return true;
	}
	
	
	@Override
	public boolean updateFullName(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setFirstname(user.getFirstname());
		userUpdate.setLastname(user.getLastname());
		entityManager.persist(userUpdate);
		return true;
	}
	
	@Override
	public boolean updatePassword(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setPassword(user.getPassword());
		userUpdate.setConfirmPassword(user.getConfirmPassword());
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updatePhoneNumber(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setPhoneNumber(user.getPhoneNumber());
		entityManager.persist(userUpdate);
		return true;
	}
	@Override
	public boolean updateUserToAdmin(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setUserType(type.admin);
		entityManager.persist(userUpdate);
		return true;
	}
	
	@Override
	public boolean updateToUser(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setUserType(type.user);
		entityManager.persist(userUpdate);
		return true;
	}
	/************************************************************************************
	 * Method:                        update login status
	 * Description:                   it updates the login status of user 
	 * @param updateLogoutStatus	  update logout to login
	 * @param updateLoginStatus		  update login to logout
	 * @returns true                  returns true   
	 ************************************************************************************/
	
	@Override
	public boolean updateLogoutStatus(User user, String email) {
		User userUpdate = getUserByEmail(email);
		if (userUpdate.getLoginStatus() == login.LoggedIn)
			return false;
		userUpdate.setLoginStatus(login.LoggedIn);
		entityManager.persist(userUpdate);
		return true;
	}
	

	@Override
	public boolean updateLoginStatus(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		if (userUpdate.getLoginStatus() == login.LoggedOut)
			return false;
		userUpdate.setLoginStatus(login.LoggedOut);
		entityManager.persist(userUpdate);
		return true;
	}
	

}
