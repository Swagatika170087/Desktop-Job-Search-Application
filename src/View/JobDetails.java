package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class JobDetails extends JPanel {

    // Table for user data
    private JTable jobTable;
    // table column
    private String[] jobTableColumn = {"Job Title", "Organization", "Skills", "Qualification", "Minimum Experience", "Maximum Experience", "Compensation", "Job Description"};

    // back button
    private JButton backButton;

    public JobDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        jobTable = new JTable();
        // scroll bar for table
        JScrollPane jobTableScroll = new JScrollPane(jobTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(jobTableScroll);

    }

    // gets users from database and loads to table
    public void getJobs(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jobTable.getModel();
        defaultTableModel.setColumnIdentifiers(jobTableColumn);
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
