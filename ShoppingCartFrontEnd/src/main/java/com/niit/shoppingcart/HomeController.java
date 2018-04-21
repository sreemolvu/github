package com.niit.shoppingcart;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.daoimpl.UserDAOImpl;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class HomeController 
{	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO; 
	@Autowired
	private ProductDAO productDAO;
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	 ModelAndView index()
	{
		//@RequestParam("message") String message
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		List<Product> products=productDAO.list_product();
		mv.addObject("productlist", products);
		//mv.addObject("message",message);
		return mv;
	}
	
	@RequestMapping("/accessDenied")
	public ModelAndView error() {
		
		ModelAndView mv = new ModelAndView("errorpage");	
		
		return mv;
	}
	
	/*@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		return mv;
	}*/

}
