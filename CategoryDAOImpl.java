package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Category;
@EnableTransactionManagement
@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	public CategoryDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(Category category) {
		try {
			Session s=sessionfactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			//sessionFactory.getCurrentSession().save(category);
			s.save(category);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch blockry
			e.printStackTrace();
			return false;
		}

	}

		
	   @Transactional
		public boolean update(Category category) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.update(category);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public boolean delete(Category category) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.delete(category);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public Category get(String id) {

			String hql = "from Category where id=" + " ' " + id + "'";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<Category> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		}
	@Transactional
		public List<Category> list() {
			String hql = "from Category";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();

		}
	
	
	
	
}
