package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class HomeController 
{	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO; 
	@RequestMapping("/")
	 ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
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
