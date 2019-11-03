package dao;

import java.util.List;

import main.Blogcomment;

public interface Blogcommentdao {
	public boolean addcomment(Blogcomment comment);
	public boolean deletecomment(Blogcomment comment);
	public List<Blogcomment> listBlogcomment(int blogcommentid);
	public Blogcomment getBlogcomment(int blogcommentid);
}
