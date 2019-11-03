package dao;

import java.util.List;

import main.Friend;

public interface Frienddao {
	 public List<Friend> showPendingFriendRequest(String username);
	 public List<Friend> showFriendList(String username);
	 public List<String> showSuggestedFriend(String username);
	 
	 public boolean deleteFriendRequest(int friendid);
	 public boolean acceptFriendRequest(int friendid);
	 public boolean sendFriendRequest(Friend friend);
}
