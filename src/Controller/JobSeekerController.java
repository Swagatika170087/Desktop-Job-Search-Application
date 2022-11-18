package Controller;

import Model.JobSeekerDatabase;
import Model.JobSeeker;
import View.JobSeekerForm;
import View.JobSeekerDetails;
import View.JobSeekerLoginForm;

import javax.swing.*;
import java.io.File;

public class JobSeekerController {
    // database file
    private String databaseFile = "database/database.txt";
    private JobSeekerDatabase jobSeekerDatabase;
    private JobSeekerForm jobSeekerForm;
    private JobSeekerLoginForm jobSeekerLoginForm;
    private JobSeekerDetails jobSeekerDetails;

    public JobSeekerController(JobSeekerForm jobSeekerForm, JobSeekerDetails jobSeekerDetails) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerForm = jobSeekerForm;
        this.jobSeekerDetails = jobSeekerDetails;

        // submit job seeker
        this.jobSeekerForm.submitJobSeekers(e -> {
            String firstname = this.jobSeekerForm.getFirstname().trim();
            String lastname = this.jobSeekerForm.getLastname().trim();
            String emailId = this.jobSeekerForm.getEmailId().trim();
            String phoneNo = this.jobSeekerForm.getPhoneNo().trim();
            String city = this.jobSeekerForm.getCity().trim();
            String state = this.jobSeekerForm.getState().trim();
            String country = this.jobSeekerForm.getCountry().trim();
            String qualification = this.jobSeekerForm.getQualification().trim();
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
            } else if(city.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "City Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(state.isEmpty()) {
                    JOptionPane.showMessageDialog(this.jobSeekerForm, "State Required.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }else if(country.isEmpty()) {
                    JOptionPane.showMessageDialog(this.jobSeekerForm, "Country Required.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }else if(qualification.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Qualification Required.", "Error",
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

            this.jobSeekerDatabase.addJobSeeker(new JobSeeker(firstname, lastname, emailId, phoneNo, city, state, country, qualification, username, password));
            this.jobSeekerDatabase.saveJobSeeker(new File(databaseFile));
            this.jobSeekerForm.reset(true);
        });

        // load job seekers
        this.jobSeekerForm.viewJobSeekers(e -> {
            this.jobSeekerDetails.getJobSeekers(this.jobSeekerDatabase.loadJobSeekers(new File(databaseFile)));
        });
    }

    public JobSeekerController(JobSeekerLoginForm jobSeekerLoginForm) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerLoginForm = jobSeekerLoginForm;

        this.jobSeekerLoginForm.loginJobSeeker(e -> {
            String username = this.jobSeekerLoginForm.getUsername().trim();
            String password = new String(this.jobSeekerLoginForm.getPassword());

            if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerLoginForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerLoginForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.jobSeekerDatabase.loginJobSeeker(new JobSeeker(username, password));
            this.jobSeekerLoginForm.reset(true);
        });
    }

}
