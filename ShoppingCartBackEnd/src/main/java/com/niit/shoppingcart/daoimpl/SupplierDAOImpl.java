package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionfactory;
	public Supplier get_supplier(String id)
	{
		
		return sessionfactory.openSession().load(Supplier.class, id);
	}
	@Transactional
	public boolean save_supplier(Supplier supplier)
	{
		try {
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}

	public boolean update_supplier(Supplier supplier)
	{
		try {
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete_supplier(Supplier supplier)
	{
		try {
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<Supplier> list_supplier()
	{
		return (List<Supplier>) sessionfactory.getCurrentSession().createQuery("from Supplier").list();
	}
	

}
