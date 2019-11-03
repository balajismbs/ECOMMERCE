package colabaration.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Userdao;
import main.UserDetails;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		try 
	    {

	    

			ApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
	 Userdao u=(Userdao)ctx.getBean("userdao");
	 UserDetails s=new UserDetails();
	 s.setUsername("balaji");
	 u.addUser(s);
  
    }catch(Throwable e)
    {
    	e.printStackTrace();
    }
}}
