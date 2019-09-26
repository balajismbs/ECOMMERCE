package summa;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daopackage.Cartdao;
import daopackage.Productdao;
import springdemo.project.Product;

@Controller
public class Controllermain {
	@Autowired
	Productdao productdao;
	@Autowired
	Cartdao cartdao;
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	@RequestMapping("/main")
	public String getMain()
	{
		return "main";
	}
	@RequestMapping("/signup")
	public String getSignUp()
	{
		return "signup";
	}
	@RequestMapping("/userhome")
	public String getUserHome(HttpSession session,Model model)
	{
		String usename=SecurityContextHolder.getContext().getAuthentication().getName();
	session.setAttribute("usename", usename);
	java.util.List<Product>productlist=productdao.getAllProducts();
	model.addAttribute("productlist", productlist);
	java.util.Date dt=new java.util.Date();
	   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+usename+"/";
int size=cartdao.totalelements(cartid);
System.out.println(cartid);
 System.out.println(size);
model.addAttribute("cartsize",size);
		return "userhome";
	}
	@RequestMapping("/admin")
	public String getAdmin()
	{
		return "admin";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,Model m)
	{
		m.addAttribute("logoutstatus", true);
		m.addAttribute("logoutmessage", "logged out successfully");
		session.invalidate();
		return "login";
	}
	
}
