package com.cg.dealsdateonlinegiftshopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dealsdateonlinegiftshopping.dao.UserDaoImplementation;
import com.cg.dealsdateonlinegiftshopping.entity.User;
import com.cg.dealsdateonlinegiftshopping.entity.User.login;
import com.cg.dealsdateonlinegiftshopping.entity.User.type;
import com.cg.dealsdateonlinegiftshopping.exception.UserException;
import com.cg.dealsdateonlinegiftshopping.service.UserService;




@SpringBootTest
@RunWith(SpringRunner.class)
class DealsDateOnlineGiftShoppingApplicationTests {


	@Autowired
	private UserService service;

	@MockBean
	private UserDaoImplementation repository;

	@BeforeEach
	public void init() {

	}
	
	
	
	/*
	 * To test addUser()
	 */

	
	public User getUserEntity() {
		User entity = new User();
		entity.setUserId(0);
		entity.setFirstname("kapil");
		entity.setLastname("chaudhary");
		entity.setPassword("kapil");
		entity.setConfirmPassword("kapil");
		entity.setEmail("kapil@gmail.com");
		entity.setPhoneNumber("7557396021");
		entity.setUserType(type.admin);
		entity.setLoginStatus(login.LoggedIn);
		return entity;
	}
	
	
	
	
	
	
	@Test
	void testSetUsertId() {
		int userId=1000;
		User entityUser=new User();
		entityUser.setUserId(userId);
		assertEquals(entityUser.getUserId(),userId);
	}

	/*
	 * To test getUserId() ,getter to get value of userId
	 */
	
	@Test
	void testGetUserId() {
		
		User entityUser=new User();
		entityUser.setUserId(1000);
		int userId=1000;
		int result=entityUser.getUserId();
		assertEquals(userId,result);
	}
	
	

	

	/*
	 * To test setUserName() ,setter to set value of User first Name
	 */
	
	@Test
	void testSetFirstName() {
		String name="Chocolate";
		User entityUser=new User();
		entityUser.setFirstname(name);
		assertEquals(entityUser.getFirstname(),name);
	}


	/*
	 * To test getUserName() ,getter to get value of user first Name
	 */
	
	@Test
	void testGeFirstName() {
		
		User entityUser=new User();
		entityUser.setFirstname("Chocolate");
		String name="Chocolate";
		String result=entityUser.getFirstname();
		assertEquals(name,result);
	}

	
	/*
	 * To test setUserName() ,setter to set value of User last Name
	 */
	
	@Test
	void testSetLastName() {
		String name="Kumar";
		User entityUser=new User();
		entityUser.setFirstname(name);
		assertEquals(entityUser.getFirstname(),name);
	}


	/*
	 * To test getUserName() ,getter to get value of user last Name
	 */
	
	@Test
	void testGetLastName() {
		
		User entityUser=new User();
		entityUser.setFirstname("Kumar");
		String name="Kumar";
		String result=entityUser.getFirstname();
		assertEquals(name,result);
	}
	

	/*
	 * To test setPhoneNumber() ,setter to set value of User PhoneNumber
	 */
	
	@Test
	void testSetPhoneNumber() {
		String no="7557396021";
		User entityUser=new User();
		entityUser.setPhoneNumber(no);
		assertEquals(entityUser.getPhoneNumber(),no);
	}
	
	


	/*
	 * To test getPhoneNumber() ,getter to get value of user PhoneNumber
	 */
	
	@Test
	void testGetPhoneNumber() {
		
		User entityUser=new User();
		entityUser.setPhoneNumber("7557396021");
		String no="7557396021";
		String result=entityUser.getPhoneNumber();
		assertEquals(no,result);
	}
	
	
	/*
	 * To test setPassword() ,setter to set value of User Password
	 */
	
	@Test
	void testSetPassword() {
		String password="7557396021";
		User entityUser=new User();
		entityUser.setPassword(password);
		assertEquals(entityUser.getPassword(),password);
	}


	/*
	 * To test getPassword() ,getter to get value of user Password
	 */
	
	@Test
	void testGetPassword() {
		
		User entityUser=new User();
		entityUser.setPassword("kapil");
		String password="kapil";
		String result=entityUser.getPassword();
		assertEquals(password,result);
	}
	
	
	/*
	 * To test setPassword() ,setter to set value of User Password
	 */
	
	@Test
	void testSetConfirmPasswor() {
		String password="7557396021";
		User entityUser=new User();
		entityUser.setPassword(password);
		assertEquals(entityUser.getPassword(),password);
	}


	
	/*
	 * To test getConfirmPassword() ,getter to get value of user ConfirmPassword
	 */
	
	@Test
	void testGetConfirmPassword() {
		User entityUser=new User();
		entityUser.setConfirmPassword("kapil");
		String password="kapil";
		String result=entityUser.getConfirmPassword();
		assertEquals(password,result);
	}
	
	
	
	
	
	

}
