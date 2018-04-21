package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO 
{
	public boolean save_cart(Cart cart);
	public boolean update_cart(Cart cart);
	//public boolean update(String emailID);
	public boolean delete_cart(Cart cart);
	public Cart get_cart(String id);
	public List<Cart>   list_cart(String pid,String emailID);
	public List<Cart>   list_full_cart(String emailID);	
}
