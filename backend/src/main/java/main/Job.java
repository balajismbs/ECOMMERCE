package main;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "jobidseq",sequenceName="jobid_seq")
public class Job {
	   @Id
	     @GeneratedValue(strategy =GenerationType.SEQUENCE ,generator="jobidseq")
	     private int jobid;
	     private String description;
	     private String designation;
	     private String companyname;
	     private String location;
	     private int ctc;
	     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	     private Date lastdateforapply;
	     private String skills;

}
