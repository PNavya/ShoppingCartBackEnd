package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class TestCaseProduct {

	//to write test case for product,we need productDAO and product object
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	//you can write a method to initialize the objects
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
		product=(Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase()
	{
		product.setId("Pr01");
		boolean flag=productDAO.delete(product);
		assertEquals("deleteProductTestCase",flag,false);
	}
	@Test
	public void addProductTestCase()
	{
		product.setId("M01");
		product.setName("titan");
		product.setDescription("This is titan watch");
		product.setPrice(25000);
		product.setQuantity("2");
		
		assertEquals("addProductTestCase",productDAO.save(product),true);
		
	}
	@Test
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase",productDAO.list().size(),2);

	}
	@Test
	public void updateProductTestCase()
	{
		product.setId("M02");
		product.setPrice(2000);
		assertEquals("updateProductTestCase",productDAO.update(product),true);

	}
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase",productDAO.get("M02"),null);

	}
	

}
