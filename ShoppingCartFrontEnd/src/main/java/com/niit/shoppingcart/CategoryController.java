package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;


@Controller
public class CategoryController
{
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping("/managecategory")
	 public ModelAndView category()
		{
			ModelAndView mv=new ModelAndView("managecategory");
			List<Category> categories = categoryDAO.list_category();
			mv.addObject("categories",categories);
			
			return mv;
		}
	@RequestMapping("/cat")
	public ModelAndView createCategory(@RequestParam("ID")String id,@RequestParam("Description")String description,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/managecategory");
		
		Category category=new Category();
		
		category.setId(id);
		category.setDescription(description);
		category.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(categoryDAO.save_category(category))
		{
			mv.addObject("successmessage","Successfully created category..");
		}
		else
		{
			mv.addObject("failuremessage","Category not created..try again");
		}
		return mv;
	}
	
	@RequestMapping("/deleteC")
	public ModelAndView deleteCategory(@RequestParam("id")String id)
	{
		System.out.println("in deelete cat");
		ModelAndView mv=new ModelAndView("redirect:/managecategory");
		
		try {
			categoryDAO.delete_category(id);
			mv.addObject("successmsg","Product deleted ");
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			mv.addObject("failuremsg","Product exist within this category...couldn't delete ");
		}
		
		System.out.println("exiting deleet cat");
		return mv;
	}
	@RequestMapping("/editC")
	public ModelAndView editCategory(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("updatecategory");
		
		Category category=categoryDAO.get_category(id);
		
		mv.addObject("category",category);
		
		return mv;
	}
	@RequestMapping("/Upcat")
	public ModelAndView updateCategory(@RequestParam("ID")String id,@RequestParam("Description")String description,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/managecategory");
		
		Category category=new Category();
		
		category.setId(id);
		category.setDescription(description);
		category.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(categoryDAO.update_category(category))
		{
			mv.addObject("successmessage","Successfully Updated category..");
		}
		else
		{
			mv.addObject("failuremessage","Category not Updated..try again");
		}
		return mv;
	}

}
