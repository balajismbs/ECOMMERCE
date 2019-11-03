package implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Frienddao;
import main.Friend;
@Repository
@Transactional
public class Frienddaoimpl implements Frienddao{
	@Autowired
	SessionFactory sessionFactory;
	public List<Friend> showPendingFriendRequest(String username) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend  f where f.username=:fname and f.status='P'");
		query.setParameter("fname",username);
        List<Friend> pendingfriendList=query.list();
		return pendingfriendList;
		
	}

	public List<Friend> showFriendList(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend f where (f.username=:uname or f.friendname=:fname) and f.status='A'");
		query.setParameter("uname", username);
		query.setParameter("fname", username);
		List<Friend> friendlist=query.list();
		return friendlist;
		
	}

	public List<String> showSuggestedFriend(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("select distinct friendname from friend");
		List<String> userdetaillist=query.list();
		System.out.println("suggested "+userdetaillist);
		return userdetaillist;
		
	}

	public boolean deleteFriendRequest(int friendid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Friend friend=session.get(Friend.class, friendid);
		
		session.delete(friend);
		return true;
		
	}

	public boolean acceptFriendRequest(int friendid) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.getCurrentSession();
		Friend friend=session.get(Friend.class, friendid);
		
		friend.setStatus("A");
		session.update(friend);
		return true;
		
	}

	public boolean sendFriendRequest(Friend friend) {
		// TODO Auto-generated method stub
		friend.setStatus("P");
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		return true;
	
	}

}
