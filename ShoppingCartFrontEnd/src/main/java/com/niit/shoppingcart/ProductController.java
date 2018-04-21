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
	@RequestMapping("/admin/p")
	 ModelAndView product()
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		List<Product> products=productDAO.list_product();
		mv.addObject("products", products);
		mv.addObject("msg", "");
		return mv;
	}

	@RequestMapping("/admin/pro")
	public ModelAndView createProduct(@RequestParam("ID")String id,
			@RequestParam("Description")String description,
			@RequestParam("name")String name,
			@RequestParam("price")String price,
			@RequestParam("stock")String stock,
			@RequestParam("categorylist")String cid,
			@RequestParam("supplierlist")String sid,
			@RequestParam MultipartFile file) 
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		Product product =new Product();
		product.setId(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setStock(Integer.parseInt(stock));
		product.setCategoryID(categoryDAO.get_category(cid));
		product.setSuppilerID(supplierDAO.get_supplier(sid));
		
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(productDAO.save_product(product))
		{
			mv.addObject("msg","Successfully created product..");
			if(fileUtil.fileCopyNIO(file, id +".PNG"))
			{
				mv.addObject("msg", "product  successfully updated");
			}
			else
			{
				mv.addObject("msg", "Could not upload image");
			}
		}
		else
		{
			mv.addObject("msg","Product not created..try again");
		}
		return mv;
	}
	@RequestMapping("/admin/deleteP")
	public ModelAndView deleteProduct(@RequestParam("id")String id)
	{
		Product product;
		ModelAndView mv=new ModelAndView("redirect:/admin");
		try {
			System.out.println("in deletepppppppppppppp");
			product=productDAO.get_product(id);
			productDAO.delete_product(product);
			System.out.println("returned from delete method");
			mv.addObject("msg","Succefully deleted product");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mv.addObject("msg","couldn't delete product");
		}
		
		return mv;
	}
	@RequestMapping("/admin/editP")
	public ModelAndView editProduct(@RequestParam("id")String id)
	{
		
		ModelAndView mv=new ModelAndView("updateproduct");
		Product product=null;
		try {
			product = productDAO.get_product(id);
			System.out.println(product.getDescription());
			mv.addObject("msg", "");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mv.addObject("msg", "");
		}
		
		mv.addObject("product",product);
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories",categories);
		
		List<Supplier> suppliers= supplierDAO.list_supplier();
		mv.addObject("suppliers",suppliers);
		
		return mv;
	}
	@RequestMapping("/admin/Uppro")
	public ModelAndView updateproduct(@RequestParam("id")String id,
			@RequestParam("description")String description,
			@RequestParam("name")String name,
			@RequestParam("price")String price,
			@RequestParam("stock")String stock,
			@RequestParam("categorylist")String cid,
			@RequestParam("supplierlist")String sid,
			@RequestParam MultipartFile file)  
	//public ModelAndView register(@RequestBody User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/admin");
		
		Product product=new Product();
		System.out.println(id+""+description+""+name+""+price+""+cid+""+sid);
		product.setId(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setStock(Integer.parseInt(stock));
		Category category=categoryDAO.get_category(cid);
		product.setCategoryID(category);
		Supplier supplier=supplierDAO.get_supplier(sid);
		product.setSuppilerID(supplier);
		System.out.println(product);
		//System.out.println(name+"---"+password+"---"+m+"---"+mail);
		if(productDAO.update_product(product))
		{
			mv.addObject("msg","Successfully Updated product..");
			if(fileUtil.fileCopyNIO(file, id +".PNG"))
			{
				mv.addObject("msg", "product image successfully updated");
			}
			else
			{
				mv.addObject("msg", "Could not upload image");
			}
		}
		else
		{
			mv.addObject("msg","product not Updated..try again");
		}
		return mv;
	}

	
	@RequestMapping("/products")
	  public ModelAndView productsDetails(@RequestParam("id")String cid)
	{
		ModelAndView mv=new ModelAndView("products");
		List<Product> products=productDAO.list_product_cat(cid);
		mv.addObject("products",products);
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories", categories);
		return mv;
	}
	
	@RequestMapping("/product")
	  public ModelAndView productDetails(@RequestParam("id")String pid)
	{
		ModelAndView mv=new ModelAndView("product");
		List<Product> product=productDAO.list_product_pro(pid);
		mv.addObject("product",product);
		List<Category> categories = categoryDAO.list_category();
		mv.addObject("categories", categories);
		return mv;
	}
}
