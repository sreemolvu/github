package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO 
{
	public Supplier get_supplier(String id);
	
	public boolean save_supplier(Supplier supplier);

	public boolean update_supplier(Supplier supplier);

	public boolean delete_supplier(Supplier supplier);
	
	public List<Supplier> list_supplier();
}
