package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;

public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	//you can write a method to initialize the objects
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier=(Supplier) context.getBean("supplier");
	}
	@Test
	public void deleteSupplierTestCase()
	{
		supplier.setId("Pr01");
		boolean flag=supplierDAO.delete(supplier);
		assertEquals("deleteSupplierTestCase",flag,false);
	}
	@Test
	public void addSupplierTestCase()
	{
		supplier.setId("M01");
		supplier.setName("xyz");
		supplier.setAddress("banglr");
		
		
		assertEquals("addSupplierTestCase",supplierDAO.save(supplier),true);
		
	}
	@Test
	public void listSupplierTestCase()
	{
		assertEquals("listSupplierTestCase",supplierDAO.list().size(),2);

	}
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("M02");
		supplier.setName("navya");
		assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);

	}
	@Test
	public void getSupplierTestCase()
	{
		assertEquals("getSupplierTestCase",supplierDAO.get("M02"),null);

	}
	

	

}
