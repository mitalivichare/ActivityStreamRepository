package com.stackroute.activitystream.userservice;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@ContextConfiguration(locations={"classpath.application.properties"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserServiceApplicationTests 
{
	//@Autowired
	private static User user;

	@Autowired
	private UserDAO userDAO;


	@BeforeClass
	public static void init() {
		user=new User();
	}

	/**
	 * 
	 */
	@Test
	public void createUserTest() {
		user.setFirstName("lmn");
		user.setLastName("lmn");
		user.setEmailId("lmn@gmail.com");
		user.setPassword("lmn");
		user.setContactNumber("9076835678");
		//user.setUserStatus("Active");
		assertEquals("Registration Successfull", true, userDAO.createUser(user));
	}
	
	  //@Test
	  public void authenticateUserTest() 
	  {
		  user.setEmailId("mitali@gmail.com"); 
		  user.setPassword("mitali");
		  assertEquals("Login successfull", User.class,userDAO.authenticateUser(user).getClass());
	  }
	  
	  //@Test
	  public void deleteUserTest()
	  {
		  assertEquals("Delete User Test Successfull", true, userDAO.deleteUser("abc@gmail.com"));
	  }
	  
	  //@Test
	  public void updateUserTestCase()
	  {
		user=userDAO.getUserByUserId("shivani@gmail.com");
		user.setContactNumber("85435678907");
		assertEquals("Update User Test Case Successfull", true,userDAO.updateUser(user));
	  }

}
