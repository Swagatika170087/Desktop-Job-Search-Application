package Model;

import View.AdminHomeFrame;
import View.JobSeekerFrame;
import View.JobSeekerHomeFrame;
import View.JobSeekerLoginForm;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class JobSeekerDatabase {
    private ArrayList<JobSeeker> jobSeekerArrayList;
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:src/database/GroupB.db";
    private Connection connection = null;
    private PreparedStatement statement = null;
    private JLabel messageLabel;

    public JobSeekerDatabase() {
        jobSeekerArrayList = new ArrayList<>();
    }

    // adds job seeker to our collection
    public void addJobSeeker(JobSeeker jobSeeker) {
        jobSeekerArrayList.add(jobSeeker);
    }

    // saves job seeker to database file
    public void saveJobSeeker(File file) {
        try {
            // job seeker model
            JobSeeker jobSeeker;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < jobSeekerArrayList.size()) {
                jobSeeker = jobSeekerArrayList.get(i);
                save_data = jobSeeker.getFirstname() +
                            ", " + jobSeeker.getLastname() +
                            ", " + jobSeeker.getEmailId() +
                            ", " + jobSeeker.getPhoneNo() +
                            ", " + jobSeeker.getCity() +
                            ", " + jobSeeker.getState() +
                            ", " + jobSeeker.getCountry() +
                            ", " + jobSeeker.getUsername() +
                            ", " + jobSeeker.getPassword();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginJobSeeker(JobSeeker jobSeeker) {
        messageLabel = new JLabel();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.prepareStatement("SELECT username, password FROM User WHERE username=? and password=?");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.setString(1,jobSeeker.getUsername());
            statement.setString(2, jobSeeker.getPassword());
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                JobSeekerHomeFrame jobSeekerHomeFrame = new JobSeekerHomeFrame();
                jobSeekerHomeFrame.setLocationRelativeTo(null);
                jobSeekerHomeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jobSeekerHomeFrame.setVisible(true);
            }else{
                messageLabel.setText("Invalid Username/Password. Please Try Again.");
                System.out.println("Invalid Username/Password. Please Try Again.");
            }
        } catch(SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if(statement!=null)
                    connection.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
            finally {
                try {
                    if(connection!=null)
                        connection.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
            }
        }

    }

    // reads job seeker from database file
    public Object[] loadJobSeekers(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}