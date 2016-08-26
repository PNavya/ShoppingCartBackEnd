package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.UserDetails;

public class UserDetailsTest {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		UserDetailsDAO userdetailsDAO= (UserDetailsDAO) context.getBean("userdetailsDAO");
		UserDetails userdetails= (UserDetails) context.getBean("userdetails");
		userdetails.setId("P001");
		userdetails.setName("Navya");
		userdetails.setPassword("navya");
		userdetails.setEmail("pn@gmail.com");
		userdetails.setContact("56231");
		if(userdetailsDAO.save(userdetails)==true)
		{
			System.out.println("UserDetails created successfully");
		}
		else
		{
			System.out.println("Not able create the userdetails");

		
		}

		
		
	}

}
