package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class JobSeekerDetails extends JPanel {

    // Table for user data
    private JTable jobSeekerTable;
    // table column
    private String[] jobSeekerTableColumn = {"FIRST NAME", "LAST NAME", "Email Id", "Phone Number", "Address", "Username", "Password"};

    // back button
    private JButton backButton;

    public JobSeekerDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        jobSeekerTable = new JTable();
        // scroll bar for table
        JScrollPane jobSeekerTableScroll = new JScrollPane(jobSeekerTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(jobSeekerTableScroll);

    }

    // gets users from database and loads to table
    public void getJobSeekers(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jobSeekerTable.getModel();
        defaultTableModel.setColumnIdentifiers(jobSeekerTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
