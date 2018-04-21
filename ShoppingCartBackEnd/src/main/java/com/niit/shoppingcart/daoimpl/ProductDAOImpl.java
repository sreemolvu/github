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

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")

public class ProductDAOImpl implements ProductDAO
{
	private Product product; 
	@Autowired
	private SessionFactory sessionfactory;
	Transaction transaction = null;
	
	public Product get_product(String id) 
	{
		System.out.println("in get");
		Session s=null;
		try 
		{
			System.out.println("get try getsession");
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			System.out.println("get opensession");
			s=sessionfactory.openSession();
		}
		
		try
		{
		
			System.out.println("geting product");
			transaction = s.beginTransaction();
			Product product=null;
			try {
				product = (Product)s.load(Product.class,id);
				System.out.println(product.getDescription());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			transaction.commit();
			System.out.println("exiting get");
			return product;
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

	public boolean save_product(Product product) 
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
			s.save(product);
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

	public boolean update_product(Product product)
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
System.out.println("in update");
		try
		{
			transaction = s.beginTransaction();
			s.update(product);
			transaction.commit();
			System.out.println("craeted");
			return true;
		} 
		catch (Exception e) 
		{
			if(transaction != null) {
                transaction.rollback();
		 }
			System.out.println(e.getMessage());
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

	public boolean delete_product(Product product) 
	{
		Session s=null;
		try 
		{
			System.out.println("in getsession");
			s = sessionfactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			System.out.println("in opensession");
			s=sessionfactory.openSession();
		}
		try {
		
			/*if (product == null) {
				System.out.println("null product");
				return false;
			}*/
			System.out.println("Transaction");
			transaction = s.beginTransaction();
			System.out.println("begin");
			try {
				System.out.println("in delete try");
				s.delete(product);
				System.out.println("try close");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("in delete catch");
			}
			System.out.println("go commit");
			transaction.commit();
			System.out.println("commited");
			System.out.println("deletedddddd");
			return true;
		} catch (Exception e) {
			
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

	public List<Product> list_product()
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
		List<Product> product=new ArrayList<Product>();
		try 
		{
			transaction = s.beginTransaction();
			product=(List<Product>) s.createQuery("from Product").list();
			transaction.commit();
			return product;
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


	public List<Product> list_product_cat(String cid)
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
		String hql="from Product where cid='"+cid+"'";
		List<Product> product=new ArrayList<Product>();
		try 
		{
			transaction = s.beginTransaction();
			product=s.createQuery(hql).list();
			transaction.commit();
			return product;
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

	public List<Product> list_product_pro(String pid) 
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
		String hql="from Product where id='"+pid+"'";
		List<Product> product=new ArrayList<Product>();
		try 
		{
			transaction = s.beginTransaction();
			product= s.createQuery(hql).list();
			transaction.commit();
			return product;
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
