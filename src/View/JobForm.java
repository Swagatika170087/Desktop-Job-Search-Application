package View;

import javax.swing.*;
import javax.swing.text.Document;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.ActionListener;

public class JobForm extends JPanel {

    private JTextField jobTitleField;
    private JTextArea jobDescField;
    private JTextField skillsField;
    private JTextField companyField;
    private JTextField locationField;
    private JTextField compensationField;
    private JTextField qualificationField;
    private JTextField experienceField;

    private JButton addButton;
    private JButton viewButton;

    public JobForm() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        JLabel jobTitleLabel = new JLabel("Job Title: ");
        JLabel jobDescLabel = new JLabel("Job Description: ");
        JLabel skillsLabel = new JLabel("Skills: ");
        JLabel companyLabel = new JLabel("Organization: ");
        JLabel locationLabel = new JLabel("Location: ");
        JLabel compensationLabel = new JLabel(" Compensation: ");
        JLabel qualificationLabel = new JLabel("Qualification: ");
        JLabel experienceLabel = new JLabel("Experience: ");

        jobTitleField = new JTextField(25);
        jobDescField = new JTextArea();
        skillsField = new JTextField(25);
        companyField = new JTextField(25);
        locationField = new JTextField(25);
        compensationField = new JTextField(25);
        qualificationField = new JTextField(25);
        experienceField = new JTextField(25);

        addButton = new JButton("Add User");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Users");
        viewButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(jobTitleLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(jobTitleField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(jobDescLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(jobDescField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(skillsLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(skillsField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;

        add(companyLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;

        add(companyField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = buttonInset;

        add(locationLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;

        add(locationField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = buttonInset;

        add(compensationLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;

        add(compensationField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = buttonInset;

        add(qualificationLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;

        add(qualificationField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = buttonInset;

        add(experienceLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;

        add(experienceField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }

    // getters
    public String getJobTitle() {
        return jobTitleField.getText();
    }

    public String getJobDesc() {
        return jobDescField.getText();
    }

    public String getSkills() {
        return skillsField.getText();
    }

    public String getCompany() {
        return companyField.getText();
    }

    public String getLocationField() {
        return locationField.getText();
    }

    public String getCompensation() {
        return compensationField.getText();
    }

    public String getQualification() {
        return qualificationField.getText();
    }

    public String getExperience() {
        return experienceField.getText();
    }

    public void submitJobs(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewJobs(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            jobTitleField.setText("");
            jobDescField.setText("");
            skillsField.setText("");
            companyField.setText("");
            locationField.setText("");
            compensationField.setText("");
            qualificationField.setText("");
            experienceField.setText("");
        }
    }
}