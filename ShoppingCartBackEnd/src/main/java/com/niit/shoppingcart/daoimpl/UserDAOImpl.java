package com.niit.shoppingcart.daoimpl;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")

public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	public UserDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public UserDAOImpl()
	{
	}


	public User get_user(String emailID) 
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
	
		User user=null;
		try 
		{
			
			 transaction = s.beginTransaction();
			
			user=(User)s.load(User.class,emailID);
			
			 transaction.commit();
			 System.out.println(user.getName());
			 log.debug("Ending of the save method");
			return user;
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

	public boolean save_user(User user)
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
			s.save(user);
			transaction.commit();
			log.debug("Ending of the save method");
			return true;
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
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
	
	
	public boolean update_user(User user) 
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
			s.update(user);
			transaction.commit();
			log.debug("Ending of the save method");
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

	public boolean delete_user(User user) 
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
			s.delete(user);
			transaction.commit();
			log.debug("Ending of the save method");
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
	
	public List<User> list_user() 
	{
		log.debug("Starting of the list method");
	Session s=null;
	try 
	{
		s=sessionfactory.getCurrentSession();
	}
	catch (HibernateException e)
	{
		s=sessionfactory.openSession();
	}
	List<User> user=new ArrayList<User>();
	try
	{
		transaction = s.beginTransaction();
		user=(List<User>) s.createQuery("from User").list();
		transaction.commit();
		log.debug("Ending of the save method");
		return user;
	} 
	catch (Exception e)
	{
		if(transaction != null) {
            transaction.rollback();
	 }
		System.out.println("ERROR");
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
