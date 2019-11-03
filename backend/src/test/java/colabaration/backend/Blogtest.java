package colabaration.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Blogdao;
import main.Blog;




public class Blogtest {
	static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Conf.class);
	}
	@Test
	public void testAddBlog() {
		Blogdao c=(Blogdao)context.getBean("blogdao");
		Blog b=new Blog();
		b.setBlogcontent("its based on social media");
		b.setBlogid(1);
		b.setBlogname("social media");
		b.setCreateDate(null);
		b.setDislike(10);
		b.setLikes(20);
		b.setStatus("active");
		b.setUsername("vishal");
		c.addBlog(b);
		
	}

	@Test
	public void testUpdateBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteblog() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testListBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testListBlogForApproval() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementLikes() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementDisLikes() {
		fail("Not yet implemented");
	}

	@Test
	public void testApproveBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testRejectBlog() {
		fail("Not yet implemented");
	}

}
