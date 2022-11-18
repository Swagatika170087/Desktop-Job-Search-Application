package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JobSeekerLoginForm extends JPanel {

    JButton login;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    public JobSeekerLoginForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        usernameField = new JTextField(25);
        passwordField = new JPasswordField(25);

        login = new JButton("Login");
        login.setPreferredSize(new Dimension(100, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20, 0, 0, 0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(usernameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(usernameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(passwordLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(passwordField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(login, gridBagConstraints);
    }

    // getters
    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public void loginJobSeeker(ActionListener actionListener) {
        login.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if (bln) {
            usernameField.setText("");
            passwordField.setText("");
        }
    }
}