package colabaration.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import implement.Blogcommentdaoimpl;
import implement.Blogdaoimpl;
import implement.Forumdaoimpl;
import implement.Frienddaoimpl;
import implement.Jobdaoimpl;
import implement.ProfilePicturedaoimpl;
import implement.Userimpl;
import main.Blog;
import main.Blogcomment;
import main.Forum;
import main.Friend;
import main.Job;
import main.ProfilePicture;
import main.UserDetails;
@Configuration
@EnableTransactionManagement
public class Conf {
	public DataSource getOracleDatasource()
    {
    	
    	DriverManagerDataSource dt=new DriverManagerDataSource();
    	dt.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dt.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    	dt.setUsername("hr");
    	dt.setPassword("oracle");
		return dt;
    }
    
    
  //========================================SESSION FACTORY=====================================================================
    
    
    @Autowired
    @Bean
    public SessionFactory getSessionFactory() {	
    	Properties pro=new Properties();
    	pro.put("hibernate.hbm2ddl.auto","update");
    	pro.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
    	LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getOracleDatasource());
    	builder.addProperties(pro);
    	builder.addAnnotatedClass(UserDetails.class);
    	builder.addAnnotatedClass(Job.class);
    	builder.addAnnotatedClass(Blog.class);
    	builder.addAnnotatedClass(Blogcomment.class);
    	builder.addAnnotatedClass(Forum.class);
    	builder.addAnnotatedClass(Friend.class);
    	builder.addAnnotatedClass(ProfilePicture.class);
    	SessionFactory session=builder.buildSessionFactory();
    	return session;
    }
    
    
  //========================================HIBERNATE TRANSACTION MANAGER========================================================
    
    
    @Autowired
    @Bean("tx")
    public HibernateTransactionManager getHibernateTransctionManager() {
    	HibernateTransactionManager tx=new HibernateTransactionManager(getSessionFactory());
    	return tx;
    }
    @Autowired
    @Bean("userdao")
	  public Userimpl getUserdao()
	  {
		  Userimpl Userimpl=new Userimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("jobdao")
	  public Jobdaoimpl getJobdao()
	  {
		  Jobdaoimpl Userimpl=new Jobdaoimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("blogcommentdao")
	  public Blogcommentdaoimpl getBlogcommentdao()
	  {
    	Blogcommentdaoimpl Userimpl=new Blogcommentdaoimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("blogdao")
	  public Blogdaoimpl getBlogdao()
	  {
		  Blogdaoimpl Userimpl=new Blogdaoimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("forumdao")
	  public Forumdaoimpl getForumdao()
	  {
		  Forumdaoimpl Userimpl=new Forumdaoimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("frienddao")
	  public Frienddaoimpl getFrienddaodao()
	  {
		  Frienddaoimpl Userimpl=new Frienddaoimpl();
		  return Userimpl;
	  }
    @Autowired
    @Bean("profilepicturedao")
	  public ProfilePicturedaoimpl getProfilePicturedao()
	  {
		  ProfilePicturedaoimpl Userimpl=new ProfilePicturedaoimpl();
		  return Userimpl;
	  }

}
