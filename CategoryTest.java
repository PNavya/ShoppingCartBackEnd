package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.configuration.ApplicationContextConfig;
import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
	
	static AnnotationConfigApplicationContext context;
		public CategoryTest()
		{
			context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
			context.scan("com.niit");
			//context.refresh();
		}
		public static void main(String[] args)
		{
		CategoryTest cat=new CategoryTest();
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		Category category= (Category) context.getBean("category");
		category.setId("CG005");
		category.setName("xyzw");
		category.setDescription("This is category 05 description");
		if(categoryDAO.save(category)==true)
		{
			System.out.println("Category created successfully");
		}
		else
		{
			System.out.println("Not able create the category");

		
		}

		
		
	}

}
