package Controller;

import Model.JobSeekerDatabase;
import Model.JobSeeker;
import View.JobSeekerForm;
import View.JobSeekerDetails;

import javax.swing.*;
import java.io.File;

public class JobSeekerController {
    // database file
    private String databaseFile = "database/database.txt";
    private JobSeekerDatabase jobSeekerDatabase;
    private JobSeekerForm jobSeekerForm;
    private JobSeekerDetails jobSeekerDetails;

    public JobSeekerController(JobSeekerForm jobSeekerForm, JobSeekerDetails jobSeekerDetails) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerForm = jobSeekerForm;
        this.jobSeekerDetails = jobSeekerDetails;

        // submit job seeker
        this.jobSeekerForm.submitUsers(e -> {
            String firstname = this.jobSeekerForm.getFirstname().trim();
            String lastname = this.jobSeekerForm.getLastname().trim();
            String emailId = this.jobSeekerForm.getEmailId().trim();
            String phoneNo = this.jobSeekerForm.getPhoneNo().trim();
            String address = this.jobSeekerForm.getAddress().trim();
            String username = this.jobSeekerForm.getUsername().trim();
            String password = this.jobSeekerForm.getPassword().trim();

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(emailId.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Email Id Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(phoneNo.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Contact Number Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(address.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Address Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.jobSeekerDatabase.addJobSeeker(new JobSeeker(firstname, lastname, emailId, phoneNo, address, username, password));
            this.jobSeekerDatabase.saveJobSeeker(new File(databaseFile));
            this.jobSeekerForm.reset(true);
        });

        // load job seekers
        this.jobSeekerForm.viewUsers(e -> {
            this.jobSeekerDetails.getJobSeekers(this.jobSeekerDatabase.loadJobSeekers(new File(databaseFile)));
        });
    }
}
