package summa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daopackage.Cartdao;
import daopackage.Paymentdao;
import daopackage.Supplierdao;
import springdemo.project.Carts;
import springdemo.project.Payments;
import springdemo.project.Suppliers;
@Controller
public class Paymentcontroller {
	@Autowired
	Paymentdao paymentdao;
	@Autowired
	Cartdao cartdao;
	@ModelAttribute("addpayment")
	
	 
	public Payments getPayments()
	{
		return new Payments();
	}
	  @RequestMapping(value="bill", method=RequestMethod.POST)
	   public String addtopayment(Payments cart,HttpSession session)
	   {
		  String username=(String)session.getAttribute("usename");
		    java.util.Date dt=new java.util.Date();
		   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
			cart.setCartid(cartid);
			paymentdao.addPayment(cart);
			return "redirect:paymentdetails";
	   }
	@RequestMapping("/paymentdetails")
	public String getPaymentDetails(Model model,HttpServletRequest request,HttpSession session)
	{
		  String username=(String)session.getAttribute("usename");
		  java.util.Date dt=new java.util.Date();
		String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		java.util.List<Payments> productlist=paymentdao.getAllPayment(cartid);
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("id");
		java.util.List<Payments> supplierlist=paymentdao.getAllPayment(cartid);
		model.addAttribute("paymentlist",supplierlist);
		if(id!=null)
			
		{
			int pid=Integer.parseInt(id);
		
			Payments p=paymentdao.find(pid);
           model.addAttribute("currproduct",p);   
           return "editpayment";
           
		}
		 
		 return "paymentdetails";
	}
	@RequestMapping(value="addpayment",method=RequestMethod.POST)
	public String addPayment(Payments product)
	{
		paymentdao.addPayment(product);
				
		
		return "redirect:paymentdetails";
	} 		
	@RequestMapping(value="updatepayment",method=RequestMethod.POST)
	public String updatePayment(Payments product)
	{
		int id=product.getId();
	   Payments p=paymentdao.find(id);
	   p.setPaymentmethod(product.getPaymentmethod());
	   p.setShippingaddress(product.getShippingaddress());
	
   
	   paymentdao.updatePayment(p);
				
		
		return "redirect:paymentdetails";	
	}

 @RequestMapping("/deletepayment")
 public String deletepayment(HttpServletRequest request)
 {
	 int id=Integer.parseInt(request.getParameter("id"));
    Payments pr=paymentdao.find(id);
   paymentdao.deletePayment(pr);
    return "redirect:paymentdetails";
 }
}
