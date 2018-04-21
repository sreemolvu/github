package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;


public interface ProductDAO 
{
public Product get_product(String id);
	
	public boolean save_product(Product product);

	public boolean update_product(Product product);

	public boolean delete_product(Product product);
	
	public List<Product> list_product();
	public List<Product> list_product_cat(String cid);
	public List<Product> list_product_pro(String pid);
}
