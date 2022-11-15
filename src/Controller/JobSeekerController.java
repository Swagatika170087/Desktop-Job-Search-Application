package Controller;

import Model.Database;
import Model.JobSeeker;
import View.Form;
import View.JobSeekerDetails;

import javax.swing.*;
import java.io.File;

public class JobSeekerController {
    // database file
    private String databaseFile = "file:src\\database\\database.txt";
    private Database database;
    private Form form;
    private JobSeekerDetails jobSeekerDetails;

    public JobSeekerController(Form form, JobSeekerDetails jobSeekerDetails) {
        this.database = new Database();
        this.form = form;
        this.jobSeekerDetails = jobSeekerDetails;

        // submit job seeker
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String lastname = this.form.getLastname().trim();
            String emailId = this.form.getEmailId().trim();
            String phoneNo = this.form.getPhoneNo().trim();
            String address = this.form.getAddress().trim();
            String username = this.form.getUsername().trim();
            String password = this.form.getPassword().trim();

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(emailId.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Email Id Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(phoneNo.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Contact Number Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(address.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Address Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.database.addJobSeeker(new JobSeeker(firstname, lastname, emailId, phoneNo, address, username, password));
            this.database.saveJobSeeker(new File(databaseFile));
            this.form.reset(true);
        });

        // load job seekers
        this.form.viewUsers(e -> {
            this.jobSeekerDetails.getJobSeekers(this.database.loadJobSeekers(new File(databaseFile)));
        });
    }
}
