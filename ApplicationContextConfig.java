package com.niit.ShoppingCart.configuration;

	import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.CategoryDAOImpl;
import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.dao.ProductDAOImpl;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.dao.SupplierDAOImpl;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAOImpl;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;
import com.niit.ShoppingCart.model.UserDetails;



@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement



public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/navya"); 
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.hbm2dll.auto", "update");
	    properties.put("hibernate.current_session_context_class", "thread");
	    return properties;
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    sessionBuilder.addAnnotatedClasses(Supplier.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	    sessionBuilder.addAnnotatedClasses(UserDetails.class);
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionmanager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	    @Autowired
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		    
		 
		    return new CategoryDAOImpl( sessionFactory);
		}
	    @Autowired
	    @Bean(name="category")
	    public Category getCategory()
	    {
	    	return new Category();
	    }

	    @Autowired
		@Bean(name="productDAO")
		public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		    
		 
		    return new ProductDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="product")
	    public Product getProduct()
	    {
	    	return new Product();
	    }
	    @Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		    
		 
		    return new SupplierDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="supplier")
	    public Supplier getSupplier()
	    {
	    	return new Supplier();
	    }
	    @Autowired
		@Bean(name="userdetailsDAO")
		public UserDetailsDAO getUserDetailsDAO(SessionFactory sessionFactory) {
		    
		 
		    return new UserDetailsDAOImpl(sessionFactory);
		}
	    @Autowired
	    @Bean(name="userdetails")
	    public UserDetails getUserDetails()
	    {
	    	return new UserDetails();
	    }




}