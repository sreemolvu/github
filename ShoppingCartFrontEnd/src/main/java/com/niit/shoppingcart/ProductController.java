package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.util.FileUtil;



@Controller
public class ProductController
{
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	FileUtil fileUtil;
	@RequestMapping("/manageproduct")
	 ModelAndView product()
	{
		ModelAndView mv=new ModelAndView("manageproduct");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		List<Product> products=productDAO.list_product();
		mv.addObject("products", products);
		return mv;
	}

	@RequestMapping("/pro")
	public ModelAndView createProduct(@RequestParam("ID")String id,
			@RequestParam("Description")String description,
			@RequestParam("name")String name,
			@RequestParam("price")String price,
			@RequestParam("categorylist")String cid,
			@RequestParam("supplierlist")String sid,
			@RequestParam MultipartFile file) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/manageproduct");
		Product product =new Product();
		product.setId(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setCategoryID(categoryDAO.get_category(cid));
		product.setSuppilerID(supplierDAO.get_supplier(sid));
		
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(productDAO.save_product(product))
		{
			mv.addObject("successmessage","Successfully created product..");
			if(fileUtil.fileCopyNIO(file, id +".PNG"))
			{
				mv.addObject("uploadMessage", "product image successfully updated");
			}
			else
			{
				mv.addObject("uploadMessage", "Could not upload image");
			}
		}
		else
		{
			mv.addObject("failuremessage","Product not created..try again");
		}
		return mv;
	}
	@RequestMapping("/deleteP")
	public ModelAndView deleteProduct(@RequestParam("id")String id)
	{
		ModelAndView mv=new ModelAndView("redirect:/manageproduct");
		
		productDAO.delete_product(id);
		
		
		return mv;
	}
	@RequestMapping("/editP")
	public ModelAndView editProduct(@RequestParam("id")String id)
	{
		
		ModelAndView mv=new ModelAndView("updateproduct");
		Product	product=productDAO.get_product(id);
		
		mv.addObject("product",product);
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		
		return mv;
	}
	@RequestMapping("/Uppro")
	public ModelAndView updateproduct(@RequestParam("ID")String id,
			@RequestParam("description")String description,
			@RequestParam("name")String name,
			@RequestParam("price")String price,
			@RequestParam("categorylist")String cid,
			@RequestParam("supplierlist")String sid,
			@RequestParam MultipartFile file)  
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/manageproduct");
		
		Product product=new Product();
		System.out.println(id+""+description+""+name+""+price+""+cid+""+sid);
		product.setId(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		Category category=categoryDAO.get_category(cid);
		product.setCategoryID(category);
		Supplier supplier=supplierDAO.get_supplier(sid);
		product.setSuppilerID(supplier);
		System.out.println(product);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(productDAO.update_product(product))
		{
			mv.addObject("successmsg","Successfully Updated product..");
			if(fileUtil.fileCopyNIO(file, id +".PNG"))
			{
				mv.addObject("uploadMessage", "product image successfully updated");
			}
			else
			{
				mv.addObject("uploadMessage", "Could not upload image");
			}
		}
		else
		{
			mv.addObject("failuremsg","product not Updated..try again");
		}
		return mv;
	}

	
	@RequestMapping("/products")
	  public ModelAndView productsDetails(@RequestParam("id")String cid)
	{
		ModelAndView mv=new ModelAndView("products");
		List<Product> products=productDAO.list_product_cat(cid);
		mv.addObject("products",products);
		return mv;
	}
	
	@RequestMapping("/product")
	  public ModelAndView productDetails(@RequestParam("id")String pid)
	{
		ModelAndView mv=new ModelAndView("product");
		List<Product> product=productDAO.list_product_pro(pid);
		mv.addObject("product",product);
		return mv;
	}
}
