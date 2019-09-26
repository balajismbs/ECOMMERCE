package summa;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daopackage.Categoriesdao;
import springdemo.project.Categories;
@Controller
public class Categorycontroller {
	@Autowired
	Categoriesdao categoriesdao;
	@ModelAttribute("addcategory")
	public Categories getCategories()
	{
		return new Categories();
	}
	@RequestMapping("/categorydetails")
	public String getCategoryDetails(Model model,HttpServletRequest request)
	{
		java.util.List<Categories> productlist=categoriesdao.getAllProducts();
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("id");
		java.util.List<Categories> supplierlist=categoriesdao.getAllProducts();
		model.addAttribute("categorylist",supplierlist);
		if(id!=null)
			
		{
			int pid=Integer.parseInt(id);
			Categories p=categoriesdao.find(pid);
           model.addAttribute("currproduct",p);   
           return "editcategory";
           
		}
		 
		 return "categorydetails";
	}
	@RequestMapping(value="addcategory",method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("addcategory")Categories product,Errors br,Model model,HttpServletRequest request)
	{
		if(br.hasErrors())
		{
			java.util.List<Categories> productlist=categoriesdao.getAllProducts();
	     	 model.addAttribute("productlist", productlist);
			String id=request.getParameter("id");
			java.util.List<Categories> supplierlist=categoriesdao.getAllProducts();
			model.addAttribute("categorylist",supplierlist);
			return "categorydetails";
		}
			return "categorydetails";
		

		
			
	}	
	@RequestMapping(value="updatecategory",method=RequestMethod.POST)
	public String updateCategory(Categories product)
	{
		int id=product.getCategoryid();
	   Categories p=categoriesdao.find(id);
	   p.setCategoryname(product.getCategoryname());
	   
	
   
	   categoriesdao.updateCategory(p);
				
		
		return "redirect:categorydetails";	
	}

 @RequestMapping("/deletecategory")
 public String deleteproduct(HttpServletRequest request)
 {
	 int id=Integer.parseInt(request.getParameter("id"));
    Categories pr=categoriesdao.find(id);
    categoriesdao.deleteCategory(pr);
    return "redirect:categorydetails";
 }
}
