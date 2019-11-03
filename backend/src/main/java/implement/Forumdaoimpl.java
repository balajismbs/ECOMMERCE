package implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Forumdao;
import main.Forum;
@Repository
@Transactional
public class Forumdaoimpl implements Forumdao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addForum(Forum forum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(forum);
		return true;
	
	}

	public Forum getForum(int forumid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Forum  forum=session.get(Forum.class,forumid);
		return forum;
		
	}

	public boolean delete(Forum forum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(forum);
		return true;
		
	}

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(forum);
		return true;
		
	}

	public List<Forum> listForum() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forumlist=query.list();
		return forumlist;
		
	}

}
