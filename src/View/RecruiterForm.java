package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecruiterForm extends JPanel {

    private JTextField firstnameField;
    private JTextField lastNameField;
    private JTextField emailIdField;
    private JTextField phoneNoField;
    private JTextField companyField;
    private JTextField addressField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton addButton;
    private JButton viewButton;

    public RecruiterForm() {

        JLabel firstnameLabel = new JLabel("First Name: ");
        JLabel lastnameLabel = new JLabel("Last Name: ");
        JLabel emailIdLabel = new JLabel("Email Id: ");
        JLabel phoneNoLabel = new JLabel("Phone #: ");
        JLabel companyLabel = new JLabel("Organization #: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel usernameLabel = new JLabel(" Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        firstnameField = new JTextField(25);
        lastNameField = new JTextField(25);
        emailIdField = new JTextField(25);
        phoneNoField = new JTextField(25);
        companyField = new JTextField(25);
        addressField = new JTextField(25);
        usernameField = new JTextField(25);
        passwordField = new JPasswordField(25);

        addButton = new JButton("Add Recruiter");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Recruiters");
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

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(firstnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(lastNameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(emailIdLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(emailIdField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;

        add(phoneNoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;

        add(phoneNoField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = buttonInset;

        add(companyLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;

        add(companyField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = buttonInset;

        add(addressLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;

        add(addressField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = buttonInset;

        add(usernameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;

        add(usernameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = buttonInset;

        add(passwordLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;

        add(passwordField, gridBagConstraints);

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
    public String getFirstname() {
        return firstnameField.getText();
    }

    public String getLastname() {
        return lastNameField.getText();
    }

    public String getEmailId() {
        return emailIdField.getText();
    }

    public String getPhoneNo() {
        return phoneNoField.getText();
    }
    public String getCompany() {
        return companyField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void submitUsers(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewUsers(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            firstnameField.setText("");
            lastNameField.setText("");
            emailIdField.setText("");
            phoneNoField.setText("");
            companyField.setText("");
            addressField.setText("");
            usernameField.setText("");
            passwordField.setText("");
        }
    }
}
