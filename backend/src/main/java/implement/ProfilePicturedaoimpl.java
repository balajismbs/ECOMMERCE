package implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Frienddao;
import dao.ProfilePicturedao;
import main.Friend;
import main.ProfilePicture;

@Repository
@Transactional
public class ProfilePicturedaoimpl implements ProfilePicturedao  {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addProfilePicture(ProfilePicture pic) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(pic);
		System.out.println(pic);
		return true;
		
	}

	public ProfilePicture getProfilePicture(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture pic=session.get(ProfilePicture.class,username);
		return pic;
		
	}



}
