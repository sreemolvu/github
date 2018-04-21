package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
	public Category get_category(String id);

	public boolean save_category(Category category);

	public boolean update_category(Category category);

	public boolean delete_category(Category category);
	
	public List<Category> list_category();

}
