package implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.Jobdao;
import main.Job;

@Repository
@Transactional
public class Jobdaoimpl implements Jobdao{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		return true;
	}

	public boolean delete(Job job) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session .delete(job);
		return true;
		
	}

	public List<Job> displayJob() {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Job> joblist=session.createQuery("from Job").list();
		
		return joblist;
		
	}

	public Job getJobDetails(int jobid) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		Job job=session.get(Job.class, jobid);
		
		return job;
		
	}

}
