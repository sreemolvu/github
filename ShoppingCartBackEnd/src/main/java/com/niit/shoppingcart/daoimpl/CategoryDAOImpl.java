package com.niit.shoppingcart.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;


@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO 
{
	
	private Category category;
	@Autowired
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	
	public Category get_category(String id)
	{
	System.out.println("in getcat method");
		Session s=null;
		try 
		{
			System.out.println("in get try");
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			System.out.println("in catch try");
			s=sessionfactory.openSession();
			System.out.println("session open");
		}
		 
	   try 
	   {
		   System.out.println("trans begin get");
		   transaction = s.beginTransaction();
		Category c=null;
		try {
			System.out.println("in load try");
			c = (Category) s.load(Category.class,id);
			System.out.println(c.getDescription());
		} catch (Exception e) {
			System.out.println("in load catch");
			System.out.println(e.getMessage());
		}
		System.out.println("trans commit get");
		transaction.commit();	
		return c;
	   } 
	   catch (Exception e)
	   {
		   if(transaction != null) {
               transaction.rollback();
		 }
		   System.out.println("Error in getcategory");
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
	
	public boolean save_category(Category category)
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
				s.save(category);
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
	
	public boolean update_category(Category category)
	{
		System.out.println("In upadete category");
		Session s=null;
		try 
		{
			System.out.println("in try update");
			s=sessionfactory.getCurrentSession();
		} catch (HibernateException e)
		{
			System.out.println("in catch update");
			s=sessionfactory.openSession();
		}

		
		try
		{
			transaction = s.beginTransaction();
			s.update(category);
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
	
	public boolean delete_category(Category category)
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
			s.delete(category);
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
	
	public List<Category> list_category() 
	{
		//return  sessionfactory.getCurrentSession().createQuery("from Category").list();
		Session s=null;
		try 
		{
			s=sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		List<Category> categorylist=new ArrayList<Category>();
		
		try 
		{
			transaction = s.beginTransaction();
			categorylist=(List<Category>) s.createQuery("from Category").list();
			transaction.commit();
			return categorylist;
		}
		catch (Exception e)
		{
			System.out.println("Category not saved");
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
