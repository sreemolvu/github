package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionfactory;
	

	public UserDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public UserDAOImpl() {
	}

	@Transactional
	public User get_user(String emailID) 
	{
		return sessionfactory.getCurrentSession().load(User.class,emailID);
	}

	@Transactional
	public boolean save_user(User user)
	{
		System.out.println("in impl");
		try {
			sessionfactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Transactional
	public User validate(String emailID,String password)
	{
		return(User)sessionfactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("emailID",emailID)).add(Restrictions.eq("password",password)).uniqueResult();
	}

	public boolean update_user(User user) {
		try {
			sessionfactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete_user(User user) 
	{
		try {
			sessionfactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<User> list_user() {
		return (List<User>) sessionfactory.getCurrentSession().createQuery("from User").list();
	}

	
	

}
