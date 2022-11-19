import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TestDBConnection01 {

    Connection connection = null;

    public TestDBConnection01() {
    }

    public void runTest() {

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database/GroupB.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String query = "select * from Recruiter INNER JOIN User ON User.userId = Recruiter.userId";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                // read the result set
                System.out.print("RecruiterId = " + rs.getInt("recruiterId"));
                System.out.print("  ");
                System.out.print("Fname = " + rs.getString("firstName"));
                System.out.print("  ");
                System.out.print("Lname = " + rs.getString("lastName"));
                System.out.print("  ");
                System.out.println("Company = " + rs.getString("Company"));
            }

            ResultSet rs1 = statement.executeQuery(query);

            JTable jt = new JTable();
            jt.setModel(DbUtils.resultSetToTableModel(rs1));

            JScrollPane jpane = new JScrollPane(jt);
            JPanel panel = new JPanel();
            JFrame frame = new JFrame();
            frame.setMinimumSize(new Dimension(600, 600));
            panel.add(jpane);
            frame.add(new JScrollPane(panel));
            frame.setVisible(true);
        } catch (
                SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}