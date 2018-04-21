package com.niit.shoppingcart.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired 
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	@Autowired
	private Cart cart;
	public boolean save_cart(Cart cart)
	{
		Session s=null;
		try 
		{
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		try
		{
			transaction = s.beginTransaction();
			s.save(cart);
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

	public boolean update_cart(Cart cart) 
	{
		System.out.println("In update cart");
		Session s=null;
		try 
		{
			System.out.println("cart try1");
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			System.out.println("cart catch1");
			s=sessionfactory.openSession();
		}
		try 
		{
			System.out.println("cart try2");
			transaction = s.beginTransaction();
			System.out.println("going to cart update");
			s.update(cart);
			
			System.out.println("updated cart "+cart.getEmailID()+cart.getQuantity());
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


	public boolean delete_cart(Cart cart)
	{
		System.out.println("in delete cart");
		Session s=null;
		try 
		{
			System.out.println("try1");
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			System.out.println("catch1");
			s=sessionfactory.openSession();
		}
		try {
			System.out.println("try2");
			transaction = s.beginTransaction();
			System.out.println("going to delete+++++++++++++++++");
			s.delete(cart);
			System.out.println("deleted cart");
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println("catch2");
			if(transaction != null) {
                transaction.rollback();
		 }
			return false;
		}
	}



	public Cart get_cart(String id)
	{
		Session s=null;
		int id1=Integer.parseInt(id);
		try 
		{
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		Cart c=null;
		try {
			transaction = s.beginTransaction();
			System.out.println("begin session cart+++++++++++++++++++++++");
			// it will fetch the record based on id and store in Cart class
					
					c=(Cart) s.load(Cart.class, id1);
					System.out.println("get cart succssfull+++++++++++++++++++++");
					transaction.commit();
					return c;
		} catch (Exception e)
		{
			 if(transaction != null) {
	               transaction.rollback();
			 }
			 System.out.println("error msg"+e.getMessage());
			   System.out.println("Error in getcart");
			
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

	public List<Cart> list_cart(String pid,String emailID) 
	{
		Session s=null;
		try 
		{
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		try {
			List<Cart> cartlist=new ArrayList<Cart>();
			transaction = s.beginTransaction();
			//select * from cart where emialID = ?
			String hql="from Cart where pid='"+pid+"'and emailID='"+emailID+"'";
			System.out.println("before list");
			cartlist=s.createQuery(hql).list();
			/*cart=(List<Cart>)s.createCriteria(Cart.class)
					.add(Restrictions.eq("pid", pid)).add(Restrictions.eq("emailID",emailID)).list();*/
			System.out.println("++++++++++++++++++"+cartlist+"+++++++++++++++++++++++++");
			transaction.commit();
			return cartlist;
		} catch (Exception e) {
			System.out.println("Catch list"+e.getMessage());
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
	public List<Cart> list_full_cart(String emailID) 
	{
		Session s=null;
		try 
		{
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			s=sessionfactory.openSession();
		}
		try {
			List<Cart> cartlist=new ArrayList<Cart>();
			transaction = s.beginTransaction();
			//select * from cart where emialID = ?
			cartlist=s.createCriteria(Cart.class)
					.add(Restrictions.eq("emailID",emailID)).list();
			System.out.println("+++++++"+cart+"++++++++++");
			transaction.commit();
			return cartlist;
		} catch (Exception e) {
			System.out.println("in cart full list");
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
