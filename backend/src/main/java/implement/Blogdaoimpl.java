package implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Blogdao;
import main.Blog;
@Repository
@Transactional
public class Blogdaoimpl implements Blogdao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(blog);
		return true;
		
	}

	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(blog);
		return true;
		
	}

	public boolean deleteblog(Blog blog) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(blog);
		return true;
		
	}

	public Blog getBlog(int blogid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	     Blog blog=session.get(Blog.class, blogid);
	  
		return blog;
	
	}

	public List<Blog> listBlog() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog b where b.status='A' ");
		List<Blog> bloglist=query.list();
		
		return bloglist;
	}

	public List<Blog> listBlogForApproval() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog ");
		List<Blog> bloglist=query.list();
		
		return bloglist;
		
	}

	public boolean incrementLikes(int blogid) {
		// TODO Auto-generated method stub
		Blog blog=this.getBlog(blogid);
		blog.setLikes(blog.getLikes()+1);
		Session session=sessionFactory.getCurrentSession();
		session.update(blog);
		return true;
	
	}

	public boolean incrementDisLikes(int blogid) {
		// TODO Auto-generated method stub
		Blog blog=this.getBlog(blogid);
		blog.setDislike(blog.getDislike()+1);
		Session session=sessionFactory.getCurrentSession();
		return true;
		
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		blog.setStatus("A");
		Session session=sessionFactory.getCurrentSession();
		session.update(blog);
		return true;
	
	}

	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		blog.setStatus("P");
		Session session=sessionFactory.getCurrentSession();
		session.update(blog);
		return true;
		
	}

}
