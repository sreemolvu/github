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
	@RequestMapping("/admin/c")
	 public ModelAndView category()
		{
			ModelAndView mv=new ModelAndView("redirect:/admin");
			List<Category> categories = categoryDAO.list_category();
			mv.addObject("categories",categories);
			mv.addObject("msg", "");
			return mv;
		}
	@RequestMapping("/admin/cat")
	public ModelAndView createCategory(@RequestParam("ID")String id,@RequestParam("Description")String description,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		
		Category category=new Category();
		
		category.setId(id);
		category.setDescription(description);
		category.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(categoryDAO.save_category(category))
		{
			mv.addObject("msg","Successfully created category..");
		}
		else
		{
			mv.addObject("msg","Category not created..try again");
		}
		return mv;
	}
	
	@RequestMapping("/admin/deleteC")
	public ModelAndView deleteCategory(@RequestParam("id")String id)
	{
		System.out.println("in deelete cat");
		ModelAndView mv=new ModelAndView("redirect:/admin");
		Category category;
	
		try {
			category = categoryDAO.get_category(id);
			if(categoryDAO.delete_category(category))
			{
			
			mv.addObject("msg","Succesfully deleted Category ");
			}
			else
			{
				mv.addObject("msg","Product exist within this category...couldn't delete ");
				
			}
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			mv.addObject("msg","Product exist within this category...couldn't delete ");
		}
		
		System.out.println("exiting deleet cat");
		return mv;
	}
	@RequestMapping("/admin/editC")
	public ModelAndView editCategory(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("updatecategory");
		System.out.println("++++++++++"+id+"++++++++++++");
		Category category=null;
		try {
			System.out.println("in get categry contr");
			category = categoryDAO.get_category(id);
			System.out.println("got categrory"+category.getDescription());
			mv.addObject("msg", "");
		} catch (Exception e) {
			System.out.println("ERroe"+e.getMessage());
			mv.addObject("msg", "");
		}
		
		mv.addObject("category",category);
		
		return mv;
	}
	@RequestMapping("/admin/Upcat")
	public ModelAndView updateCategory(@RequestParam("ID")String id,@RequestParam("Description")String description,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		
		Category category=new Category();
		
		category.setId(id);
		category.setDescription(description);
		category.setName(name);
		System.out.println("========================="+category.getDescription());
		if(categoryDAO.update_category(category))
		{
			mv.addObject("msg","Successfully Updated category..");
		}
		else
		{
			mv.addObject("msg","Category not Updated..try again");
		}
		return mv;
	}

}
