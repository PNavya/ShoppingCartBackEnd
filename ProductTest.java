package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		ProductDAO productDAO= (ProductDAO) context.getBean("productDAO");
		Product product= (Product) context.getBean("product");
		product.setId("P002");
		product.setName("titan");
		product.setDescription("This is product 02 description");
		product.setPrice(250);
		product.setQuantity("2");
		if(productDAO.save(product)==true)
		{
			System.out.println("Product created successfully");
		}
		else
		{
			System.out.println("Not able create the product");

		
		}

		
		
	}

}
