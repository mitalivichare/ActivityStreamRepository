package com.stackroute.activitystream.circleservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
public class CircleServiceApplicationTests {
	
	//@Autowired
	private static Circle circle;
	
	@Autowired
	CircleDAO circleDAO;


	@BeforeClass
	public static void init() {
		
		circle=new Circle();
	}
	
	//@Test
	public void createCircleTest()
	{
		circle.setCircleName("ReBoot");
		circle.setCircleOwner("lisa@gmail.com");
		circle.setCircleDescription("The Re-Boot gang");
		//circle.setCircleCreationDate();
		assertEquals(true, circleDAO.createCircle(circle));
	}
	
	//@Test
	public void updateCircle()
	{
		circle=circleDAO.getCircleByCircleId(2);
		circle.setCircleStatus("A");
		//circle.setCircleDescription("The Ghoooost Gang");
		assertEquals(true,circleDAO.updateCircle(circle));
	}
	
	@Test
	public void deleteCircle()
	{
		assertEquals("Circle Deleted Successfully", true, circleDAO.deleteCircle(3));
	}
	
	//@Test
	public void getCircleByCircleId()
	{
		//assertEquals("Fetching Circle by ID Test Successfull", "ReBoot", circleDAO.getCircleByCircleId(2).getCircleName());
		circle=circleDAO.getCircleByCircleId(4);
		assertNotNull(circle);
		display("GetCircleByCircleId",circle);
	}
	
	//@Test
	public void getCircleByCircleName()
	{
		circle=circleDAO.getCircleByCircleName("Boot");
		assertNotNull(circle);
		display("GetCircleByCircleName",circle);
	}
	
	//@Test
	public void getAllCirclesTest()
	{
		List<Circle> circleList=circleDAO.getAllCircles();
		assertNotNull(circleList);
		System.out.println("List of Circles Available");
		System.out.println("========================================");
		for(Circle circle : circleList)
		{
			System.out.println(circle);;
		}
	}
	
	public void display(String methodName,Circle circle)
	{
		System.out.println(methodName);
		System.out.println("===========================================");
		System.out.println(circle);
	}


	//@Test
	public void contextLoads() {
	}

}
