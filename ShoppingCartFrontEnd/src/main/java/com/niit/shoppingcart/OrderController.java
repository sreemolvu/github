package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Controller
public class OrderController
{
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrdersDAO ordersDAO;
	@RequestMapping("/user/orders")
	public ModelAndView orders()
	{
		User user=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String uid = auth.getName();
		ModelAndView mv=new ModelAndView("Orders");
		System.out.println("starting get user");
		user=userDAO.get_user(uid);
		//System.out.println("got userin controller"+user);
		mv.addObject("user", user);
		List<Cart> cartlist=cartDAO.list_full_cart(uid);
		mv.addObject("cartlist",cartlist);
		//System.out.println(user+"++++++++++++++++++++++++");
		//System.out.println(user.getName());
		
		return mv;
	}
	@RequestMapping("/user/order/checkout")
	public ModelAndView checkout()
	{
		ModelAndView mv=new ModelAndView("redirect:/user/orders");
	
		return mv;
	}
	@RequestMapping("/user/order/placeorder")
	public ModelAndView placeorder(@RequestParam("emailID")String emailID,
				@RequestParam("name")String name,
				@RequestParam("mobile")String mobile,
				@RequestParam("address")String address,
				@RequestParam("city")String city,
				@RequestParam("pin")int pin,
				@RequestParam("total")Float total,
				@RequestParam("pid")String pid)
	{
		ModelAndView mv=new ModelAndView("placedorder");
		Orders orders=new Orders();
		orders.setEmailID(emailID);
		orders.setUname(name);
		orders.setAddress(address);
		orders.setCity(city);
		orders.setPin(pin);
		orders.setPhone(mobile);
		orders.setTotal(total);
		
	
		try {
			ordersDAO.save_order(orders);
			List<Cart> cartlist=cartDAO.list_full_cart(emailID);
			mv.addObject("cartlist",cartlist);
			System.out.println("going to deleeteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			for (Cart cart : cartlist) 
			{
				cartDAO.delete_cart(cart);
			}
		
			mv.addObject("msg", "succesfully placed order");
		} catch (Exception e) {
			mv.addObject("msg", "your order couldn't be placed");
		}
		return mv;
	}
	/*@RequestMapping("/placedorder")
	  public ModelAndView porder()
	{
		ModelAndView mv=new ModelAndView("placedorder");
		return mv;
	}*/
}
