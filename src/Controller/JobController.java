package Controller;

import Model.Job;
import Model.JobDatabase;
import View.JobDetails;
import View.JobForm;

import javax.swing.*;
import java.io.File;

public class JobController {
     // database file
     private String databaseFile = "database/database.txt";
     private JobDatabase jobDatabase;
     private JobForm jobForm;
     private JobDetails jobDetails;
 
     public JobController(JobForm jobForm, JobDetails jobDetails) {
         this.jobDatabase = new JobDatabase();
         this.jobForm = jobForm;
         this.jobDetails = jobDetails;
 
         // submit job seeker
         this.jobForm.submitJobs(e -> {
             String jobTitle = this.jobForm.getJobTitle().trim();
             String jobDesc = this.jobForm.getJobDesc().trim();
             String skills = this.jobForm.getSkills().trim();
             String company = this.jobForm.getCompany().trim();
             String location = this.jobForm.getLocationField().trim();
             Long compensation = Long.parseLong(this.jobForm.getCompensation().trim());
             String qualification = this.jobForm.getQualification().trim();
             Integer experience = Integer.parseInt(this.jobForm.getExperience().trim());
 
             // simple validations
             if(jobTitle.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Job Title Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(jobDesc.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Job Description Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(skills.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Skills Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(company.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Organization Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(location.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Location Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(compensation == null) {
                 JOptionPane.showMessageDialog(this.jobForm, "Compensation Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             } else if(qualification.isEmpty()) {
                 JOptionPane.showMessageDialog(this.jobForm, "Qualification Required.", "Error",
                         JOptionPane.ERROR_MESSAGE);
                 return;
             }
             else if(experience == null) {
                JOptionPane.showMessageDialog(this.jobForm, "Experience Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
 
             this.jobDatabase.addJob(new Job(jobTitle, jobDesc, skills, company, location, compensation, qualification, experience));
             this.jobDatabase.saveJob(new File(databaseFile));
             this.jobForm.reset(true);
         });
 
         // load job seekers
         this.jobForm.viewJobs(e -> {
             this.jobDetails.getJobs(this.jobDatabase.loadJobs(new File(databaseFile)));
         });
     }
 
}
