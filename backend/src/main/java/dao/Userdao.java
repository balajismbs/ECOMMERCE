package dao;

import main.UserDetails;

public interface Userdao {

	  public boolean addUser(UserDetails user);
	  public boolean updateUser(UserDetails user);
	  public UserDetails getUserDetails(int userid);
	  public UserDetails checkUserCredential(UserDetails user);

}
