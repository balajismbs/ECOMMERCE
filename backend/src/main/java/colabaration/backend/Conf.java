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

import implement.Userimpl;
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
    	pro.put("hibernate.hbm2ddl.auto","create");
    	pro.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
    	LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getOracleDatasource());
    	builder.addProperties(pro);
    	builder.addAnnotatedClass(UserDetails.class);
    	
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

}
