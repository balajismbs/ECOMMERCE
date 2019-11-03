package dao;

import main.ProfilePicture;

public interface ProfilePicturedao {

	public boolean addProfilePicture(ProfilePicture pic);
	public ProfilePicture getProfilePicture(String username);
}
