package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecruiterDetails extends JPanel {

    // Table for user data
    private JTable recruiterTable;
    // table column
    private String[] recruiterTableColumn = {"FIRST NAME", "LAST NAME", "Email Id", "Phone Number", "Organization", "Address", "Username", "Password"};

    // back button
    private JButton backButton;

    public RecruiterDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        recruiterTable = new JTable();
        // scroll bar for table
        JScrollPane recruiterTableScroll = new JScrollPane(recruiterTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(recruiterTableScroll);

    }

    // gets users from database and loads to table
    public void getRecruiters(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) recruiterTable.getModel();
        defaultTableModel.setColumnIdentifiers(recruiterTableColumn);
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
