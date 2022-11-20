package Model;

import View.RecruiterHomeFrame;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class RecruiterDatabase {
    private ArrayList<Recruiter> recruiterArrayList;
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:src/database/GroupB.db";
    private Connection connection = null;
    private PreparedStatement statement = null;
    private JLabel messageLabel;

    public RecruiterDatabase() {
        recruiterArrayList = new ArrayList<>();
    }

    // adds Recruiter to our collection
    public void addRecruiter(Recruiter recruiter) {
        recruiterArrayList.add(recruiter);
    }

    // saves Recruiter to database file
    public void saveRecruiter(Recruiter recruiter) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.prepareStatement(" INSERT INTO User (firstName, lastName, email, mobile, city, state, country, username, password) " +
                    " VALUES (firstName=?, lastName=?, email=?, mobile=?, city=?, state=?, country=?, " +
                    "username=?, password=?, 'Recruiter')");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.setString(1, recruiter.getFirstname());
            statement.setString(2, recruiter.getLastname());
            statement.setString(3, recruiter.getEmailId());
            statement.setString(4, recruiter.getPhoneNo());
            statement.setString(5, recruiter.getAddress().getCity());
            statement.setString(6, recruiter.getAddress().getState());
            statement.setString(7, recruiter.getAddress().getCountry());
            statement.setString(8, recruiter.getUsername());
            statement.setString(9, recruiter.getPassword());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                rs.toString();
                statement = connection.prepareStatement(" INSERT INTO Recruiter VALUES (userId=?, company=?)");
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                statement.setString(1, String.valueOf(rs.getInt(1)));
                statement.setString(2, recruiter.getCompany());
                //JOptionPane.showMessageDialog(btnSearch, "Password has been successfully changed");
            }
        } catch(SQLException sql){
            sql.printStackTrace();
        } catch(ClassNotFoundException ex){
            Logger.getLogger(AdminDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
            /*
        try {
            // Recruiter model
            Recruiter recruiter;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < recruiterArrayList.size()) {
                recruiter = recruiterArrayList.get(i);
                save_data = recruiter.getFirstname() +
                            ", " + recruiter.getLastname() +
                            ", " + recruiter.getEmailId() +
                            ", " + recruiter.getPhoneNo() +
                            ", " + recruiter.getCompany() +
                            ", " + recruiter.getCity() +
                            ", " + recruiter.getState() +
                            ", " + recruiter.getCountry() +
                            ", " + recruiter.getUsername() +
                            ", " + recruiter.getPassword();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public void loginRecruiter(Recruiter recruiter) {
        messageLabel = new JLabel();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.prepareStatement("SELECT username, password FROM User WHERE username=? and password=?");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.setString(1, recruiter.getUsername());
            statement.setString(2, recruiter.getPassword());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                RecruiterHomeFrame recruiterHomeFrame = new RecruiterHomeFrame();
                recruiterHomeFrame.setLocationRelativeTo(null);
                recruiterHomeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                recruiterHomeFrame.setVisible(true);
            } else {
                messageLabel.setText("Invalid Username/Password. Please Try Again.");
                //System.out.println("Invalid Username/Password. Please Try Again.");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecruiterDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    // reads Recruiter from database file
    public ResultSet loadRecruiters() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.prepareStatement("SELECT * FROM User WHERE type='Recruiter'");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return rs;
            }
        } catch(SQLException sql){
            sql.printStackTrace();
        } catch(ClassNotFoundException ex){
            Logger.getLogger(AdminDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        return null;
    }
}