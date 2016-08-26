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

import com.niit.ShoppingCart.model.Supplier;
@EnableTransactionManagement

@Repository("SupplierDAO")

public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	public SupplierDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	 @Transactional
		public boolean save(Supplier supplier) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.save(supplier);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	   @Transactional
		public boolean update(Supplier supplier) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.update(supplier);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public boolean delete(Supplier supplier) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.delete(supplier);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public Supplier get(String id) {

			String hql = "from Supplier where id=" + " ' " + id + "'";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<Supplier> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		}
	@Transactional
		public List<Supplier> list() {
			String hql = "from Supplier";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();

		}
	
	
	
	
}
