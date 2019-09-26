package summa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daopackage.Userdao;
import springdemo.project.Users;

@Controller
public class Usercontroller {
@Autowired
Userdao userdao;

@RequestMapping(value="adduser" ,method=RequestMethod.POST)
public String addUser(Users user)
{
	userdao.addUser(user);
	return "login";
}

}
