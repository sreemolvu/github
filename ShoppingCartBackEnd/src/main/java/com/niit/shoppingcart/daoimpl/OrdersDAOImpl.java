package com.niit.shoppingcart.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Orders;
@Repository("OrdersDAO")
public class OrdersDAOImpl implements OrdersDAO
{
	@Autowired
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	
	public OrdersDAOImpl() 
	{
		super();
		
	}


	public OrdersDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}


	public boolean save_order(Orders orders)
	{
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		
		
		try 
		{
			transaction = s.beginTransaction();
			s.save(orders);
			transaction.commit();
			return true;
		}
		catch (Exception e)
		{
			if(transaction != null) {
                transaction.rollback();
		 }
			return false;
		}
		finally 
		 {
	       if (s.isOpen())
	       {
	           s.close();
	        }
	     }
	}

}
