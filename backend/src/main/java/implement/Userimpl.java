package implement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Userdao;
import main.UserDetails;

@Repository
@Transactional
public class Userimpl implements Userdao{
	@Autowired
	SessionFactory sessionfactory;
	
	
	
	public boolean addUser(UserDetails user) {
		Session session=sessionfactory.getCurrentSession();
		session.save(user);
		return true;
	}

	

	
	
	
	public boolean updateUser(UserDetails user) {
		Session session=sessionfactory.getCurrentSession();
		session.update(user);
		return true;
	}
	
	//====================================GET USER DETAILS=================================================================
	

	
	public UserDetails getUserDetails(int userid) {
		Session session=sessionfactory.getCurrentSession();
		UserDetails user=session.get(UserDetails.class,userid);
		
		return user;
	}

	
	//====================================CHECK UESR CREDENTIAL=============================================================
	
	
	
	public UserDetails checkUserCredential(UserDetails user) {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from  UserDetails  where username=:uname and password=:pword");
		query.setParameter("uname",user.getUsername());
		query.setParameter("pword",user.getPassword());
		
		if(query.list().size()>0)
		{
			UserDetails user1=(UserDetails) query.list().get(0);
			return user1;
		}
		else
		{
			return null;
		}
			
	}

}
