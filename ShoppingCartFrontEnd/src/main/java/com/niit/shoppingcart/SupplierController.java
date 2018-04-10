package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.Supplier;
@Controller
public class SupplierController 
{
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("/managesupplier")
	public ModelAndView category()
	{
		ModelAndView mv=new ModelAndView("managesupplier");
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		
		return mv;
	}
	@RequestMapping("/sup")
	public ModelAndView createSupplier(@RequestParam("ID")String id,@RequestParam("Address")String address,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/managesupplier");
		Supplier supplier=new Supplier();
		supplier.setId(id);
		supplier.setAddress(address);
		supplier.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(supplierDAO.save_supplier(supplier))
		{
			mv.addObject("successmessage","Successfully created supplier..");
		}
		else
		{
			mv.addObject("failuremessage","Supplier not created..try again");
		}
		return mv;
	}
	@RequestMapping("/deleteS")
	public ModelAndView deleteSupplier(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("redirect:/managesupplier");
		Supplier supplier=new Supplier();
		supplier=supplierDAO.get_supplier(id);
		try {
			supplierDAO.delete_supplier(supplier);
		} catch (Exception e)
		{
			mv.addObject("failuremsg","Product exist within this supplier...couldn't delete ");
		}
		return mv;
	}
	@RequestMapping("/editS")
	public ModelAndView editCategory(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("updatesupplier");
		Supplier supplier=supplierDAO.get_supplier(id);
		mv.addObject("supplier",supplier);
		return mv;
	}
	@RequestMapping("/Upsup")
	public ModelAndView updatesupplier(@RequestParam("ID")String id,@RequestParam("Address")String address,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/managesupplier");
		
		Supplier supplier=new Supplier();
		
		supplier.setId(id);
		supplier.setAddress(address);
		supplier.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(supplierDAO.update_supplier(supplier))
		{
			mv.addObject("successmessage","Successfully Updated supplier..");
		}
		else
		{
			mv.addObject("failuremessage","supplier not Updated..try again");
		}
		return mv;
	}

}
