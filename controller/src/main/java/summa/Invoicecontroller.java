package summa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daopackage.Cartdao;
import daopackage.Paymentdao;
import daopackage.Productdao;
import daopackage.Supplierdao;
import springdemo.project.Carts;
import springdemo.project.Payments;
import springdemo.project.Product;
import springdemo.project.Suppliers;
@Controller
public class Invoicecontroller {
 @Autowired
 Cartdao cartdao;
 @Autowired
 Productdao productdao;
 @Autowired
 Supplierdao supplierdao;
 @Autowired
 Paymentdao paymentdao;
 @RequestMapping("/invoice")
 public String viewCart(HttpSession session,Model model,HttpServletRequest request)
 {	
	    String usename=SecurityContextHolder.getContext().getAuthentication().getName();
     	session.setAttribute("usename", usename);
	   String username=(String)session.getAttribute("usename");
	   java.util.Date dt=new java.util.Date();
	   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
			   java.util.List<Carts> cartlist=cartdao.getAllProducts(cartid);
			   float sum=0;
			   for(Carts c:cartlist)
			   {
				   sum=sum+c.getAmount();
			   }
         model.addAttribute("cartlist",cartlist);
	     model.addAttribute("carttotal",sum);
	     
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
       return "invoice";
		
 }
}
