package com.niit.shoppingcart.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.SystemPropertyUtils;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	public Supplier get_supplier(String id)
	{
		log.debug("Starting of the get method");
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
			Supplier supplier=null;
			try {
				supplier = (Supplier)s.load(Supplier.class, id);
				System.out.println(supplier.getAddress());
			} catch (Exception e) {
				
			System.out.println(e.getMessage());
			}
			
			transaction.commit();
			log.debug("Ending of the get method");
			return supplier;
		}
		catch (Exception e) 
		{
			if(transaction != null) {
                transaction.rollback();
		 }
		
			return null;
		}
		finally 
		 {
	      if (s.isOpen())
	      {
	          s.close();
	       }
	    }
		
	}
	
	public boolean save_supplier(Supplier supplier)
	{
		log.debug("Starting of the save method");
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e1)
		{
			s=sessionfactory.openSession();
		}
		
		try 
		{
			transaction = s.beginTransaction();
			s.save(supplier);
			transaction.commit();
			log.debug("Ending of the get method");
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
	
	public boolean update_supplier(Supplier supplier)
	{	
		log.debug("Starting of the update method");
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e1)
		{
			s=sessionfactory.openSession();
		}
		
		try
		{
			transaction = s.beginTransaction();
			s.update(supplier);
			transaction.commit();
			log.debug("Ending of the update method");
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
	
	public boolean delete_supplier(Supplier supplier)
	{
		log.debug("Starting of the delete method");
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e1)
		{
			s=sessionfactory.openSession();
		}
		
		try
		{
			transaction = s.beginTransaction();
			s.delete(supplier);
			transaction.commit();
			log.debug("Ending of the delete method");
			return true;
		} catch (Exception e)
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
	
	public List<Supplier> list_supplier()
	{
		log.debug("Starting of the list method");
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e1)
		{
			s=sessionfactory.openSession();
		}
		List<Supplier> supplier=new ArrayList<Supplier>();
		try 
		{
			transaction = s.beginTransaction();
			supplier=(List<Supplier>) s.createQuery("from Supplier").list();
			transaction.commit();
			log.debug("Ending of the list method");
			return supplier;
		}
		catch (Exception e) 
		{
			if(transaction != null) {
                transaction.rollback();
		 }
			return null;
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
