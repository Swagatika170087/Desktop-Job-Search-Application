package Model;

import View.AdminHomeFrame;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AdminDatabase {
    private ArrayList<User> adminArrayList;
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:src/database/GroupB.db";
    private Connection connection = null;
    private PreparedStatement statement = null;
    private JLabel messageLabel;
    public void loginAdmin(User admin) {
        messageLabel = new JLabel();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.prepareStatement("SELECT username, password FROM User WHERE username=? and password=?");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.setString(1,admin.getUsername());
            statement.setString(2, admin.getPassword());
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                AdminHomeFrame adminHomeFrame = new AdminHomeFrame();
                adminHomeFrame.setLocationRelativeTo(null);
                adminHomeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                adminHomeFrame.setVisible(true);
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

    // reads admin from database file
    public Object[] loadAdmins(File file) {
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

