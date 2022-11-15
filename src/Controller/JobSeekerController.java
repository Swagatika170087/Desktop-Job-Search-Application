package Controller;

import Model.Database;
import Model.JobSeeker;
import View.Form;
import View.JobSeekerDetails;

import javax.swing.*;
import java.io.File;

public class JobSeekerController {
    // database file
    private String databaseFile = "src\\data\\database.txt";
    private Database database;
    private Form form;
    private JobSeekerDetails jobSeekerDetails;

    public JobSeekerController(Form form, JobSeekerDetails jobSeekerDetails) {
        this.database = new Database();
        this.form = form;
        this.jobSeekerDetails = jobSeekerDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String lastname = this.form.getLastname().trim();
            String emailId = this.form.getFirstname().trim();
            String phoneNo = this.form.getFirstname().trim();
            String address = this.form.getFirstname().trim();
            String username = this.form.getFirstname().trim();
            String password = this.form.getFirstname().trim();

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

        // load users
        this.form.viewUsers(e -> {
            this.jobSeekerDetails.getUsers(this.database.loadJobSeekers(new File(databaseFile)));
        });
    }
}
