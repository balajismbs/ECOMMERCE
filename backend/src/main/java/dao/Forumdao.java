package dao;

import java.util.List;

import main.Forum;

public interface Forumdao {
	 public boolean addForum(Forum forum);
	 public Forum getForum(int forumid); 
	 public boolean delete(Forum forum);
	 public boolean updateForum(Forum forum);
	 List<Forum> listForum();
}
