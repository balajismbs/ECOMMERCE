package dao;

import java.util.List;

import main.Blog;

public interface Blogdao {
public boolean addBlog(Blog blog);
public boolean updateBlog(Blog blog);
public boolean deleteblog(Blog blog);
public Blog getBlog(int blogid);
public List<Blog> listBlog();
public List<Blog> listBlogForApproval();
public boolean incrementLikes(int blogid);
public boolean incrementDisLikes(int blogid);
public boolean approveBlog(Blog blog);
public boolean rejectBlog(Blog blog);
}
