package Controller;

import Model.*;
import View.JobSeekerDetails;
import View.RecruiterDetails;
import View.JobDetails;
import View.AdminForm;
import View.AdminLoginForm;

import javax.swing.*;
import java.io.File;

public class AdminController {
    // database file
    private String jobSeekerDBFile = "database/jobseekerDB.txt";
    private JobSeekerDatabase jobSeekerDatabase;
    private JobSeekerDetails jobSeekerDetails;
    private String recruiterDBFile = "database/recruiterDB.txt";
    private RecruiterDatabase recruiterDatabase;
    private RecruiterDetails recruiterDetails;
    private String jobDBFile = "database/jobDB.txt";
    private JobDatabase jobDatabase;
    private JobDetails jobDetails;
    private AdminForm adminForm;
    private AdminLoginForm adminLoginForm;
    private AdminDatabase adminDatabase;

    public AdminController(AdminForm adminForm) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerDetails = new JobSeekerDetails();

        this.recruiterDatabase = new RecruiterDatabase();
        this.recruiterDetails = new RecruiterDetails();

        this.jobDatabase = new JobDatabase();
        this.jobDetails = new JobDetails();

        // load job seekers, jobs and Recruiters
        this.adminForm.viewJobSeekers(e -> {
           this.jobSeekerDetails.getJobSeekers(this.jobSeekerDatabase.loadJobSeekers(new File(jobSeekerDBFile)));
        });

        this.adminForm.viewRecruiters(e -> {
            this.recruiterDetails.getRecruiters(this.recruiterDatabase.loadRecruiters());
         });

         this.adminForm.viewJobs(e -> {
            this.jobDetails.getJobs(this.jobDatabase.loadJobs(new File(jobDBFile)));
         });

    }

    public AdminController(AdminLoginForm adminLoginForm) {
      this.adminDatabase = new AdminDatabase();
      this.adminLoginForm = adminLoginForm;

      this.adminLoginForm.loginAdmin(e -> {
         String username = this.adminLoginForm.getUsername().trim();
         String password = new String(this.adminLoginForm.getPassword());

         if(username.isEmpty()) {
            JOptionPane.showMessageDialog(this.adminLoginForm, "Username Required.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else if(password.isEmpty()) {
            JOptionPane.showMessageDialog(this.adminLoginForm, "Password Required.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
         User admin = new User();
         admin.setUsername(username);
         admin.setPassword(password);
         this.adminDatabase.loginAdmin(admin);
         this.adminLoginForm.reset(true);
      });
    }
    
}
