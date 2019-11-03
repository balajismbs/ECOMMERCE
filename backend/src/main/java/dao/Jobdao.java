package dao;

import java.util.List;

import main.Job;

public interface Jobdao {
	 public boolean addJob(Job job);
	 public boolean delete(Job job);
	 public List<Job> displayJob();
	 public Job getJobDetails(int jobid);

}
