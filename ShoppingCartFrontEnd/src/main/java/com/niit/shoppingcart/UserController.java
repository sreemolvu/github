package com.niit.shoppingcart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController
{
	@Autowired
	private UserDAO userdao;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	/*@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("uname")String username,@RequestParam("password")String password)
	{
		//System.out.println("In validate");
		ModelAndView mv=new ModelAndView("redirect:/");
		if(userdao.validate(username,password)==null )
		{
			mv.addObject("Errormessage","Invalid credential,plz try again");
			
		}
		else
		{
			mv.addObject("Welcomemessage","Welcome Mr./Ms. "+username);
		}
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		//System.out.println("In validate");
		ModelAndView mv=new ModelAndView("home");
		httpsession.invalidate();
		mv.addObject("Logoutmessage","Successfully logged out");
		return mv;
	}*/


	@RequestMapping("/reg")
	public ModelAndView register(@RequestParam("emailID")String mail,@RequestParam("name")String name,@RequestParam("password")String password,@RequestParam("mobile")String m)
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/login");
		mv.addObject("error", "");
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		User user=new User();
		user.setEmailID(mail);
		user.setMobile(m);
		user.setName(name);
		user.setPassword(password);
		user.setRole('c');
		user.setRegisteredDate(date);
		//user.setRegisteredDate(new Date(System.currentTimeMillis()));
		
		
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(userdao.save_user(user))
		{
			mv.addObject("message","Successfully Registered..");
		}
		else
		{
			mv.addObject("message","Not Registered..try again");
		}
		return mv;
	}
	@RequestMapping("/register")
	String nuser(Model m)
	{
		List<Category> categories = categoryDAO.list_category();
		m.addAttribute("categories", categories);
		return "register";
	}
	@RequestMapping("/login")
	String euser(Model m,@RequestParam("error")String error)
	{
		List<Category> categories = categoryDAO.list_category();
		m.addAttribute("categories", categories);
		m.addAttribute("error", error);
		return "login";
		
	}
	@RequestMapping("/homecss")
	String css()
	{
		return "homecss";
	}
	@RequestMapping("/admin")
	public ModelAndView admin(@RequestParam("msg") String msg)
	{
		ModelAndView mv=new ModelAndView("admin");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		List<Product> products=productDAO.list_product();
		mv.addObject("products", products);
		mv.addObject("msg",msg);
		return mv;
	}
	@RequestMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response,Model m) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        
	    } 
	  
	    
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
