package Controller;

import Model.Address;
import Model.JobSeekerDatabase;
import Model.JobSeeker;
import View.JobSeekerForm;
import View.JobSeekerDetails;
import View.JobSeekerLoginForm;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class JobSeekerController {
    // database file
    private String databaseFile = "database/database.txt";
    private JobSeekerDatabase jobSeekerDatabase;
    private JobSeekerForm jobSeekerForm;
    private JobSeeker jobSeeker;
    private JobSeekerLoginForm jobSeekerLoginForm;
    private JobSeekerDetails jobSeekerDetails;

    public JobSeekerController(JobSeekerForm jobSeekerForm) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerForm = jobSeekerForm;
        this.jobSeeker = new JobSeeker();
        // submit job seeker
        this.jobSeekerForm.submitJobSeekers(e -> {
            jobSeeker.setFirstname(this.jobSeekerForm.getFirstname().trim());
            jobSeeker.setLastname(this.jobSeekerForm.getLastname().trim());
            jobSeeker.setEmailId(this.jobSeekerForm.getEmailId().trim());
            jobSeeker.setPhoneNo(this.jobSeekerForm.getPhoneNo().trim());
            Address address = new Address();
            address.setCity(this.jobSeekerForm.getCity().trim());
            address.setState(this.jobSeekerForm.getState().trim());
            address.setCountry(this.jobSeekerForm.getCountry().trim());
            jobSeeker.setAddress(address);
            String[] skills = this.jobSeekerForm.getSkills().trim().split(",");
            ArrayList<String> skillSet = new ArrayList<>();
            for (String skill : skills) {
                skillSet.add(skill);
            }
            jobSeeker.setSkills(skillSet);
            String[] qualifications = this.jobSeekerForm.getQualifications().trim().split(",");
            ArrayList<String> qualificationSet = new ArrayList<>();
            for (String skill : qualifications) {
                qualificationSet.add(skill);
            }
            jobSeeker.setQualifications(qualificationSet);
            jobSeeker.setUsername(this.jobSeekerForm.getUsername().trim());
            jobSeeker.setPassword(this.jobSeekerForm.getPassword().trim());

            // simple validations
            if(jobSeeker.getFirstname().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getLastname().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getEmailId().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Email Id Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getPhoneNo().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Contact Number Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getAddress().getCity().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "City Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getAddress().getState().isEmpty()) {
                    JOptionPane.showMessageDialog(this.jobSeekerForm, "State Required.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }else if(jobSeeker.getAddress().getCountry().isEmpty()) {
                    JOptionPane.showMessageDialog(this.jobSeekerForm, "Country Required.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            } else if(jobSeeker.getUsername().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.jobSeekerDatabase.addJobSeeker(jobSeeker);
            this.jobSeekerDatabase.saveJobSeeker(new File(databaseFile));
            this.jobSeekerForm.reset(true);
        });

    }

    public JobSeekerController(JobSeekerLoginForm jobSeekerLoginForm) {
        this.jobSeekerDatabase = new JobSeekerDatabase();
        this.jobSeekerLoginForm = jobSeekerLoginForm;
        this.jobSeeker = new JobSeeker();

        this.jobSeekerLoginForm.loginJobSeeker(e -> {
            jobSeeker.setUsername(this.jobSeekerLoginForm.getUsername().trim());
            jobSeeker.setPassword(new String(this.jobSeekerLoginForm.getPassword()));

            if(jobSeeker.getUsername().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerLoginForm, "Username Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jobSeeker.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(this.jobSeekerLoginForm, "Password Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.jobSeekerDatabase.loginJobSeeker(jobSeeker);
            this.jobSeekerLoginForm.reset(true);
        });
    }


    public JobSeekerController(JobSeekerDetails jobSeekerDetails){
        this.jobSeekerDetails = jobSeekerDetails;

        // load job seekers
        this.jobSeekerForm.viewJobSeekers(e -> {
            this.jobSeekerDetails.getJobSeekers(this.jobSeekerDatabase.loadJobSeekers(new File(databaseFile)));
        });

    }

}
