package Controller;

import Model.*;
import View.JobSeekerLoginForm;
import View.RecruiterDetails;
import View.RecruiterForm;
import View.RecruiterLoginForm;

import javax.swing.*;
import java.io.File;

public class RecruiterController {
    private RecruiterLoginForm recruiterLoginForm;
    // database file
    private String databaseFile = "database/recruiterDatabase.txt";
    private RecruiterDatabase recruiterDatabase;
    private Recruiter recruiter;
    private RecruiterForm recruiterForm;
    private RecruiterDetails recruiterDetails;

    public RecruiterController(RecruiterForm recruiterForm, RecruiterDetails recruiterDetails) {
        this.recruiterDatabase = new RecruiterDatabase();
        this.recruiterForm = recruiterForm;
        this.recruiterDetails = recruiterDetails;
        this.recruiter = new Recruiter();

        // submit job seeker
        this.recruiterForm.submitRecruiters(e -> {
            recruiter.setFirstname(this.recruiterForm.getFirstname().trim());
            recruiter.setLastname(this.recruiterForm.getLastname().trim());
            recruiter.setEmailId(this.recruiterForm.getEmailId().trim());
            recruiter.setPhoneNo(this.recruiterForm.getPhoneNo().trim());
            recruiter.setCompany(this.recruiterForm.getCompany().trim());
            Address address = new Address();
            address.setCity(this.recruiterForm.getCity().trim());
            address.setState(this.recruiterForm.getState().trim());
            address.setCountry(this.recruiterForm.getCountry().trim());
            recruiter.setAddress(address);
            recruiter.setFirstname(this.recruiterForm.getState().trim());
            recruiter.setFirstname(this.recruiterForm.getCountry().trim());
            recruiter.setFirstname(this.recruiterForm.getUsername().trim());
            recruiter.setFirstname(this.recruiterForm.getPassword().trim());

            // simple validations
            if(recruiter.getFirstname().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getLastname().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getEmailId().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Email Id Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getPhoneNo().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Contact Number Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getCompany().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Organization Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getAddress().getCity().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "City Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getAddress().getState().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "State Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else if(recruiter.getAddress().getCountry().isEmpty()) {
                    JOptionPane.showMessageDialog(this.recruiterForm, "Country Required.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            } else if(recruiter.getUsername().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.recruiterDatabase.addRecruiter(recruiter);
            this.recruiterDatabase.saveRecruiter(recruiter);
            this.recruiterForm.reset(true);
        });
    }

    public RecruiterController(RecruiterLoginForm recruiterLoginForm) {
        this.recruiterDatabase = new RecruiterDatabase();
        this.recruiterLoginForm = recruiterLoginForm;
        this.recruiter = new Recruiter();

        this.recruiterLoginForm.loginRecruiter(e -> {
            recruiter.setUsername(this.recruiterLoginForm.getUsername().trim());
            recruiter.setPassword(new String(this.recruiterLoginForm.getPassword()));

            if(recruiter.getUsername().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterLoginForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(recruiter.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(this.recruiterLoginForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.recruiterDatabase.loginRecruiter(recruiter);
            this.recruiterLoginForm.reset(true);
        });
    }
}
