package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of UserDAO
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	@Ignore
	@Test
	public void saveUserTestCase()
	{
		user = new User();
		user.setEmailID("kiran@gmail.com");
		user.setMobile("444444444");
		user.setName("kiran kumar");
		user.setPassword("kiran@123");
		
	  boolean status = 	userDAO.save_user(user);
	  
	  assertEquals("save user test case", true, status);
	}
	
	@Ignore
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("jaskaran1@gmail.com");
		user.setMobile("888888888");
		boolean status = userDAO.update_user(user);
		assertEquals("update test case", true,status );
	}
	@Ignore
	@Test
	public void getUserSuccessTestCase()
	{
		
	user= userDAO.get_user("jaskaran1@gmail.com");
	
	assertNotNull("get user test case", user);
	}
	@Ignore
	@Test
	public void getUserFailureTestCase()
	{
		
	user= userDAO.get_user("jaya@gmail.com");
	
	assertNull("get user test case", user);
	}
	@Ignore
	@Test
	public void deleteUserSuccessTestCase()
	{
		user= userDAO.get_user("jaya@gmail.com");
	boolean status =	userDAO.delete_user(user);
	assertEquals("delete user succss test case" , true, status);
	
	}
	@Ignore
	@Test
	public void deleteUserFailureTestCase()
	{
		user= userDAO.get_user("jaya@gmail.com");
	boolean status =	userDAO.delete_user(user);
	assertEquals("delete user failure test case" , false, status);
	
	}
	@Ignore
	
	@Test
	public void getAllUsersTestCase()
	{
	List<User>	users = userDAO.list_user();
	
	assertEquals("get all usres " , 3, users.size() );
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
