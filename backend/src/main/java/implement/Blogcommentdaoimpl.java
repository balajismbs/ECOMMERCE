package implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Blogcommentdao;
import main.Blogcomment;
@Repository
@Transactional
public class Blogcommentdaoimpl implements Blogcommentdao{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addcomment(Blogcomment comment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(comment);
		return true;
		
	}

	public boolean deletecomment(Blogcomment comment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(comment);
		return true;
		
	}

	public List<Blogcomment> listBlogcomment(int blogcommentid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blogcomment where blogid=:id");

		query.setParameter("id", blogcommentid);
		List<Blogcomment> commentlist=query.list(); 
		return commentlist;
		
	}

	public Blogcomment getBlogcomment(int blogcommentid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Blogcomment blogcomment=session.get(Blogcomment.class,blogcommentid);
	
		return blogcomment;
		
	}

}
