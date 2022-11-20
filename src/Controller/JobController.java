package Controller;

import Model.Address;
import Model.Job;
import Model.JobDatabase;
import View.JobDetails;
import View.JobForm;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class JobController {
     // database file
     private String databaseFile = "database/database.txt";
     private JobDatabase jobDatabase;
     private JobForm jobForm;
     private JobDetails jobDetails;
     private Job job;
 
     public JobController(JobForm jobForm, JobDetails jobDetails) {
         this.jobDatabase = new JobDatabase();
         this.jobForm = jobForm;
         this.jobDetails = jobDetails;
         this.job = new Job();
 
         // submit job seeker
         this.jobForm.submitJobs(e -> {
             job.setJobTitle(this.jobForm.getJobTitle().trim());
             job.setJobDesc(this.jobForm.getJobDesc().trim());
             String[] skills = this.jobForm.getSkills().trim().split(",");
             ArrayList<String> skillSet = new ArrayList<>();
             for (String skill : skills) {
                 skillSet.add(skill);
             }
             job.setSkills(skillSet);
             job.setCompany(this.jobForm.getCompany().trim());
             Address address = new Address();
             address.setCity(this.jobForm.getLocationField().trim());
             job.setCompensation(Long.parseLong(this.jobForm.getCompensation().trim()));
             job.setQualification(this.jobForm.getQualification().trim());
             job.setExperience(Integer.parseInt(this.jobForm.getExperience().trim()));
 
             // simple validations
             if(job.getJobTitle().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Job Title Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getJobDesc().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Job Description Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getSkills().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Skills Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getCompany().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Organization Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getAddress().getCity().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Location Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getCompensation() == null) {
                 JOptionPane.showMessageDialog(this.jobForm, "Compensation Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(job.getQualification().isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Qualification Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             }
             else if(job.getExperience() == null) {
                JOptionPane.showMessageDialog(this.jobForm, "Experience Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
 
             this.jobDatabase.addJob(job);
             this.jobDatabase.saveJob(new File(databaseFile));
             this.jobForm.reset(true);
         });
 
         // load job seekers
         this.jobForm.viewJobs(e -> {
             this.jobDetails.getJobs(this.jobDatabase.loadJobs(new File(databaseFile)));
         });
     }
 
}
