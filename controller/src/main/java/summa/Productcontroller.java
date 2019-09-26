package summa;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import daopackage.Productdao;
import daopackage.Supplierdao;
import springdemo.project.Product;
import springdemo.project.Suppliers;
@Controller
public class Productcontroller {


	@Autowired
	Productdao productdao;
	@Autowired
	Supplierdao supplierdao;
	@ModelAttribute("addproduct")
	public Product getProduct()
	{
		return new Product();
	}
	@RequestMapping("/productdetails")
	public String getProductDetails( Model model,HttpServletRequest request)
	{
		
		java.util.List<Product> productlist=productdao.getAllProducts();
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("id");
		java.util.List<Suppliers> supplierlist=supplierdao.getAllSupplier();
		model.addAttribute("supplierlist",supplierlist);
		if(id!=null)
			
		{
			int pid=Integer.parseInt(id);
			Product p=productdao.findProduct(pid);
           model.addAttribute("currproduct",p);   
           return "editproduct";
           
		}
		 
		 return "productdetails";
	}
	@RequestMapping(value="addproduct",method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("addproduct")Product product,Errors br,Model model,HttpServletRequest request)
	{
		 if(br.hasErrors()) 
		 {
			 java.util.List<Product> productlist=productdao.getAllProducts();
	     	 model.addAttribute("productlist", productlist);
			String id=request.getParameter("id");
			java.util.List<Suppliers> supplierlist=supplierdao.getAllSupplier();
			model.addAttribute("supplierlist",supplierlist);
			
			 return "productdetails";
		 }
		try {
		//byte[ bt=image.getBytes();
		//	productDAO.addProduct(product);
			productdao.addProduct(product);
			MultipartFile image=(MultipartFile)product.getImage();
			byte[] bt=new byte[(int)image.getSize()];
			try {
				InputStream i=image.getInputStream();
				i.read(bt);
				FileOutputStream f=new FileOutputStream("D:\\java eclipse\\controller\\src\\main\\webapp\\resources\\images\\"+product.getId()+".jpg");
				f.write(bt);
				f.flush();
			}
			catch(Exception e) {
			      System.out.println(e);
			}
		System.out.println(bt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "redirect:productdetails";	
	} 		
	@RequestMapping(value="updateproduct",method=RequestMethod.POST)
	public String updateProduct(Product product)
	{
		int id=product.getId();
	   Product p=productdao.findProduct(id);
	   p.setCategoryid(product.getCategoryid());
	   p.setSupplierid(product.getSupplierid());
	   p.setAmount(product.getAmount());
	   p.setDescription(product.getDescription());
   p.setQuantity(product.getQuantity());
   p.setProductname(p.getProductname());
   
	   productdao.updateProduct(p);
				
		try {
		//byte[ bt=image.getBytes();
		//	productDAO.addProduct(product);
			MultipartFile image=(MultipartFile)product.getImage();
			byte[] bt=new byte[(int)image.getSize()];
			try {
				InputStream i=image.getInputStream();
				i.read(bt);
				FileOutputStream f=new FileOutputStream("D:\\java eclipse\\controller\\src\\main\\webapp\\resources\\images\\"+product.getId()+".jpg");
				f.write(bt);
				f.flush();
			}
			catch(Exception e) {
			      System.out.println(e);
			}
		System.out.println(bt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "redirect:productdetails";	
	}

 @RequestMapping("/deleteproduct")
 public String deleteproduct(HttpServletRequest request)
 {
	 int id=Integer.parseInt(request.getParameter("id"));
    Product pr=productdao.findProduct(id);
    productdao.deleteProduct(pr);
    return "redirect:productdetails";
 }
}
