package summa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daopackage.Cartdao;
import daopackage.Userdao;
import springdemo.project.Carts;

@Controller
public class Cartcontroller {
	@Autowired
	Cartdao cartdao;
	@Autowired
	Userdao userdao;

	   @RequestMapping(value="addtocart", method=RequestMethod.POST)
	   public String addtocart(Carts cart)
	   {
		    java.util.Date dt=new java.util.Date();
		   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+cart.getEmail();
			cart.setCartid(cartid);
			cartdao.addCart(cart);
			return "redirect:userhome";
	   }
	   @RequestMapping("/cart")
	   public String viewCart(HttpSession session,Model model)
	   {
		//	String usename=SecurityContextHolder.getContext().getAuthentication().getName();
		//	String usename=(String)session.getAttribute("username");
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
		   return "cart";
	   }
	   @RequestMapping("/deletecart")
	   public String delteCart(HttpServletRequest request)
	   {
		   int id=Integer.parseInt(request.getParameter("id"));
		   Carts cart=cartdao.find(id);
		  
		   cartdao.deleteCategory(cart);
		    return "redirect:cart";
	   }
}
