package Controller;

import Model.JobSeekerDatabase;
import Model.Recruiter;
import Model.RecruiterDatabase;
import View.RecruiterDetails;
import View.RecruiterForm;

import javax.swing.*;
import java.io.File;

public class RecruiterController {
    // database file
    private String databaseFile = "src\\database\\recruiterDatabase.txt";
    private RecruiterDatabase recruiterDatabase;
    private RecruiterForm recruiterForm;
    private RecruiterDetails recruiterDetails;

    public RecruiterController(RecruiterForm recruiterForm, RecruiterDetails recruiterDetails) {
        this.recruiterDatabase = new RecruiterDatabase();
        this.recruiterForm = recruiterForm;
        this.recruiterDetails = recruiterDetails;

        // submit job seeker
        this.recruiterForm.submitUsers(e -> {
            String firstname = this.recruiterForm.getFirstname().trim();
            String lastname = this.recruiterForm.getLastname().trim();
            String emailId = this.recruiterForm.getEmailId().trim();
            String phoneNo = this.recruiterForm.getPhoneNo().trim();
            String company = this.recruiterForm.getCompany().trim();
            String address = this.recruiterForm.getAddress().trim();
            String username = this.recruiterForm.getUsername().trim();
            String password = this.recruiterForm.getPassword().trim();

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(emailId.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Email Id Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(phoneNo.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Contact Number Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(company.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Organization Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(address.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Address Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.recruiterDatabase.addRecruiter(new Recruiter(firstname, lastname, emailId, phoneNo, company, address, username, password));
            this.recruiterDatabase.saveRecruiter(new File(databaseFile));
            this.recruiterForm.reset(true);
        });

        // load job seekers
        this.recruiterForm.viewUsers(e -> {
            this.recruiterDetails.getJobSeekers(this.recruiterDatabase.loadRecruiters(new File(databaseFile)));
        });
    }
}
