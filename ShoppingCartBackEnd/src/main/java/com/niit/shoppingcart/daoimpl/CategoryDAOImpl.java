package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO 
{
	
	private Category category;
	@Autowired
	private SessionFactory sessionfactory;
	public Category get_category(String id)
	{
	System.out.println("in getcat method");
	
	   Category c=sessionfactory.getCurrentSession().load(Category.class,id);
		return c;
		
	}

	public boolean save_category(Category category)
	{
		try {
			sessionfactory.getCurrentSession().save(category);
			sessionfactory.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sessionfactory.close();
			return false;
		}
	}

	public boolean update_category(Category category)
	{
		try {
			Session s=sessionfactory.openSession();
					s.update(category);
					s.close();
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete_category(String id)
	{
		System.out.println("in deletecat method"+id);
		category = get_category(id);
		System.out.println(category);
		System.out.println(category.getId());
		if (category == null) {
			System.out.println("in if");
			
			return false;
		}
		try {
			System.out.println("intry");
			Session s=sessionfactory.getCurrentSession();
					s.delete(category);
					s.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in cathc");
			return false;
		}
		
	}
	public List<Category> list_category() 
	{
		//return  sessionfactory.getCurrentSession().createQuery("from Category").list();
		return (List<Category>) sessionfactory.openSession().createQuery("from Category").list();
		
	}

	
	
	


}
