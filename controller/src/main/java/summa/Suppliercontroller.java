package summa;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import daopackage.Supplierdao;
import springdemo.project.Suppliers;
@Controller
public class Suppliercontroller {
	@Autowired
	Supplierdao supplierdao;
	@ModelAttribute("addsupplier")
	public Suppliers getSuppliers()
	{
		return new Suppliers();
	}
	@RequestMapping("/supplierdetails")
	public String getSupplierDetails(Model model,HttpServletRequest request)
	{
		java.util.List<Suppliers> productlist=supplierdao.getAllSupplier();
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("id");
		java.util.List<Suppliers> supplierlist=supplierdao.getAllSupplier();
		model.addAttribute("supplierlist",supplierlist);
		if(id!=null)
			
		{
			int pid=Integer.parseInt(id);
		
			Suppliers p=supplierdao.findSupplier(pid);
           model.addAttribute("currproduct",p);   
           return "editsupplier";
           
		}
		 
		 return "supplierdetails";
	}
	@RequestMapping(value="addsupplier",method=RequestMethod.POST)
	public String addSupplier(Suppliers product)
	{
		supplierdao.addSupplier(product);
				
		
		return "redirect:supplierdetails";	
	} 		
	@RequestMapping(value="updatesupplier",method=RequestMethod.POST)
	public String updateProduct(Suppliers product)
	{
		int id=product.getSupplierId();
	   Suppliers p=supplierdao.findSupplier(id);
	   p.setSuppliername(product.getSuppliername());
	   p.setSupplieraddress(product.getSupplieraddress());
	
   
	   supplierdao.updateProduct(p);
				
		
		return "redirect:supplierdetails";	
	}

 @RequestMapping("/deletesupplier")
 public String deleteproduct(HttpServletRequest request)
 {
	 int id=Integer.parseInt(request.getParameter("id"));
    Suppliers pr=supplierdao.findSupplier(id);
   supplierdao.deleteProduct(pr);
    return "redirect:supplierdetails";
 }
}
