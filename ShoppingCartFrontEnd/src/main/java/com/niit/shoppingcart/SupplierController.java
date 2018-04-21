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
	
	@RequestMapping("/admin/s")
	public ModelAndView category()
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		mv.addObject("msg", "");
		return mv;
	}
	@RequestMapping("/admin/sup")
	public ModelAndView createSupplier(@RequestParam("ID")String id,@RequestParam("Address")String address,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		Supplier supplier=new Supplier();
		supplier.setId(id);
		supplier.setAddress(address);
		supplier.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(supplierDAO.save_supplier(supplier))
		{
			mv.addObject("msg","Successfully created supplier..");
		}
		else
		{
			mv.addObject("msg","Supplier not created..try again");
		}
		return mv;
	}
	@RequestMapping("/admin/deleteS")
	public ModelAndView deleteSupplier(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		Supplier supplier;
		supplier=supplierDAO.get_supplier(id);
		try {
			System.out.println("in try supplier+++++++++++++++++++++++++++++++++++++++++");
			if(supplierDAO.delete_supplier(supplier))
			{
				System.out.println("nooooo errrorrr+****************************************");
			mv.addObject("msg","successfully deleted supplier");
			}
			else
			{
				mv.addObject("msg","Product exist within this supplier...couldn't delete ");
			}
		} catch (Exception e)
		{
			System.out.println("Catch**************************************");
			mv.addObject("msg","Product exist within this supplier...couldn't delete ");
		}
		return mv;
	}
	@RequestMapping("/admin/editS")
	public ModelAndView editCategory(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("updatesupplier");
		Supplier supplier=null;
		try {
			System.out.println("in get suppl cntroller");
			supplier=supplierDAO.get_supplier(id);
			System.out.println(supplier.getAddress());
			mv.addObject("msg", "");
		
		} catch (Exception e) {
			System.out.println((e.getMessage()));
			mv.addObject("msg", "");
		}
		mv.addObject("supplier",supplier);
		return mv;
	}
	@RequestMapping("/admin/Upsup")
	public ModelAndView updatesupplier(@RequestParam("ID")String id,@RequestParam("Address")String address,@RequestParam("name")String name) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		
		Supplier supplier=new Supplier();
		
		supplier.setId(id);
		supplier.setAddress(address);
		supplier.setName(name);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(supplierDAO.update_supplier(supplier))
		{
			mv.addObject("msg","Successfully Updated supplier..");
		}
		else
		{
			mv.addObject("msg","supplier not Updated..try again");
		}
		return mv;
	}

}
