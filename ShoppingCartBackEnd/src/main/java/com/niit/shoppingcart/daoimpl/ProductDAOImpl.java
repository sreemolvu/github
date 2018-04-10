package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	private Product product; 
	@Autowired
	private SessionFactory sessionfactory;
	public Product get_product(String id) 
	{
		
		return sessionfactory.openSession().load(Product.class,id);
		
	}

	public boolean save_product(Product product) 
	{
		try {
			sessionfactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		
	}

	public boolean update_product(Product product)
	{
System.out.println("in update");
		try {
			sessionfactory.getCurrentSession().update(product);
			System.out.println("craeted");
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean delete_product(String id) 
	{
		
		try {
			product = get_product(id);
			if (product == null) {
				return false;
			}
			sessionfactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<Product> list_product()
	{
		return (List<Product>) sessionfactory.getCurrentSession().createQuery("from Product").list();
	}


	public List<Product> list_product_cat(String cid)
	{
		String hql="from Product where cid='"+cid+"'";
		return sessionfactory.getCurrentSession().createQuery(hql).list();
	}

	public List<Product> list_product_pro(String pid) 
	{
		String hql="from Product where id='"+pid+"'";
		return sessionfactory.getCurrentSession().createQuery(hql).list();
	}

	

	
	
}
