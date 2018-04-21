package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class CartController 
{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private UserDAO userdao;
	@RequestMapping("/user/cart")
	public ModelAndView cart()
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String uid = auth.getName();
		ModelAndView mv=new ModelAndView("cart");
		List<Cart> cartlist=cartDAO.list_full_cart(uid);
		mv.addObject("cartlist",cartlist);
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories", categories);
		return mv;
	}
	
	@RequestMapping("/user/cart/addcart")
	public ModelAndView addcart(@RequestParam("pid")String pid)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String uid = auth.getName();
	    
		System.out.println(uid);
		ModelAndView mv=new ModelAndView("redirect:/user/cart");
		Product product=productDAO.get_product(pid);
		//List<Product> productlist=productDAO.list_product_pro(pid);
	    //mv.addObject("productlist",productlist);
		 Cart cart=new Cart();
		//cart.setEmailID(uid);
		//cart.setProductID(product);
		//cart.setQuantity(1);
		//cartDAO.save_cart(cart);
		if(product.getStock()>0)
		{
			List<Cart> cartlist =new ArrayList<Cart>();
			cartlist=cartDAO.list_cart(pid,uid);
			if(cartlist.isEmpty())
			{
				cart.setEmailID(uid);
				cart.setProductID(product);
				cart.setQuantity(1);
				product.setStock((product.getStock()-1));
				productDAO.update_product(product);
				if(cartDAO.save_cart(cart))
				{
					mv.addObject("msg","successfully added to cart");
				}
				else
				{
					mv.addObject("msg","not added to cart");
				}
					
			}
			else
			{
				cart=cartlist.get(0);
				System.out.println("in cart else++++++++++++++++++++++++++");
				cart.setEmailID(uid);
				cart.setProductID(product);
				System.out.println("productid++++++++++++"+product.getId());
				System.out.println("old Quantity+++++++++++++"+cart.getQuantity());
				cart.setQuantity(cart.getQuantity()+1);
				System.out.println("Updated quanity+++++++++++++++"+cart.getQuantity());
				product.setStock((product.getStock()-1));
				System.out.println("Going to update+++++++++++++++++++++++++++");
				productDAO.update_product(product);
				System.out.println("product updated++++++++++++++++++++");
				if(cartDAO.update_cart(cart))
				{
					mv.addObject("msg","successfully added to cart");
				}
				else
				{
					mv.addObject("msg","not added to cart");
				}
			}
		
		}
		else
		{
			mv.addObject("message","No stock left");
		}
		
		return mv;
	}
	@RequestMapping("/user/cart/update")
	public ModelAndView updatecart(@RequestParam("pid")String pid,@RequestParam("quantity")int q)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String uid = auth.getName();
	  
		System.out.println(uid);
		ModelAndView mv=new ModelAndView("redirect:/user/cart");
		Product product=productDAO.get_product(pid);
		  List<Product> productlist=productDAO.list_product_pro(pid);
		    mv.addObject("productlist",productlist);
		 Cart cart=new Cart();
		 List<Cart> cartlist =new ArrayList<Cart>();
			cartlist=cartDAO.list_cart(pid,uid);
		//cart.setEmailID(uid);
		//cart.setProductID(product);
		//cart.setQuantity(1);
		//cartDAO.save_cart(cart);
		if(product.getStock()>0)
		{
				cart=cartlist.get(0);
				System.out.println("in cart else++++++++++++++++++++++++++");
				cart.setEmailID(uid);
				cart.setProductID(product);
				System.out.println("productid++++++++++++"+product.getId());
				System.out.println("old Quantity+++++++++++++"+cart.getQuantity());
				product.setStock((product.getStock()+(cart.getQuantity()-q)));
				cart.setQuantity(q);
				System.out.println("Updated quanity+++++++++++++++"+cart.getQuantity());
				
				System.out.println("Going to update+++++++++++++++++++++++++++");
				productDAO.update_product(product);
				System.out.println("product updated++++++++++++++++++++");
				if(cartDAO.update_cart(cart))
				{
					mv.addObject("msg","successfully updated to cart");
				}
				else
				{
					mv.addObject("msg","not updated to cart");
				}
		
		}
		else
		{
			mv.addObject("message","No stock left");
		}
		
		return mv;
	}
	@RequestMapping("/user/cart/delete")
	public ModelAndView deleteCart(@RequestParam("pid")String pid,@RequestParam("id")String id)
	{
		
		ModelAndView mv=new ModelAndView("redirect:/user/cart");
		System.out.println(id+"+++++++++++++++++++++++++++++++++++++");
		Cart cart=new Cart();
		Product product=new Product();
		product=productDAO.get_product(pid);
		try {
			cart= cartDAO.get_cart(id);
			cartDAO.delete_cart(cart);
			System.out.println("old stock"+product.getStock());
			product.setStock((product.getStock()+cart.getQuantity()));
			System.out.println("new stock"+product.getStock());
			productDAO.update_product(product);
			mv.addObject("msg","Succesfully deleted Cart ");
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			mv.addObject("msg","Cart couldn't be deleted ");
		}
	
		return mv;
	}
	

}
