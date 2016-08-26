package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.UserDetails;

public class TestCaseUserDetails {

	@Autowired
	UserDetailsDAO userdetailsDAO;
	
	@Autowired
	UserDetails userdetails;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userdetailsDAO=(UserDetailsDAO) context.getBean("userdetailsDAO");
		userdetails=(UserDetails) context.getBean("userdetails");
	}
	@Test
	public void userdetailsListTestCase()
	{
		List<UserDetails> list =userdetailsDAO.list();
		int rowCount=list.size();
		assertEquals("UserDetails List Test Case",rowCount,5);
	}
	@Test
	public void userdetailsAddTestCase()
	{
		userdetails.setId("001");
		userdetails.setName("navya");
		userdetails.setPassword("xyz");
		userdetails.setEmail("pn@gmail.com");
		userdetails.setContact("12345");
		userdetails.setAddress("hyd");
		
		boolean flag=userdetailsDAO.save(userdetails);
		assertEquals(flag,true);


	}
	@Test
	public void userdetailsGetTestCase()
	{
		userdetails= userdetailsDAO.get("C001");
		System.out.println(userdetails.getEmail());
		System.out.println(userdetails.getName());

		assertEquals(userdetails.getName(),"navya");
	}
	

	

}
