package Controller;

import Model.Recruiter;
import Model.RecruiterDatabase;
import View.RecruiterDetails;
import View.RecruiterForm;

import javax.swing.*;
import java.io.File;

public class RecruiterController {
    // database file
    private String databaseFile = "database/recruiterDatabase.txt";
    private RecruiterDatabase recruiterDatabase;
    private RecruiterForm recruiterForm;
    private RecruiterDetails recruiterDetails;

    public RecruiterController(RecruiterForm recruiterForm, RecruiterDetails recruiterDetails) {
        this.recruiterDatabase = new RecruiterDatabase();
        this.recruiterForm = recruiterForm;
        this.recruiterDetails = recruiterDetails;

        // submit job seeker
        this.recruiterForm.submitRecruiters(e -> {
            String firstname = this.recruiterForm.getFirstname().trim();
            String lastname = this.recruiterForm.getLastname().trim();
            String emailId = this.recruiterForm.getEmailId().trim();
            String phoneNo = this.recruiterForm.getPhoneNo().trim();
            String company = this.recruiterForm.getCompany().trim();
            String city = this.recruiterForm.getCity().trim();
            String state = this.recruiterForm.getState().trim();
            String country = this.recruiterForm.getCountry().trim();
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
            } else if(city.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "City Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(state.isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "State Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else if(country.isEmpty()) {
                    JOptionPane.showMessageDialog(this.recruiterForm, "Country Required.", "Error",
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

            this.recruiterDatabase.addRecruiter(new Recruiter(firstname, lastname, emailId, phoneNo, company, city, state, country, username, password));
            this.recruiterDatabase.saveRecruiter(new File(databaseFile));
            this.recruiterForm.reset(true);
        });

        // load Recruiters
        this.recruiterForm.viewRecruiters(e -> {
            this.recruiterDetails.getRecruiters(this.recruiterDatabase.loadRecruiters(new File(databaseFile)));
        });
    }
}
