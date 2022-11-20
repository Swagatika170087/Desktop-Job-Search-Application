package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminForm extends JPanel{
    private JButton jobSeeker;
    private JButton recruiter;
    private JButton job;

    public AdminForm() {
        super();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents(){
        jobSeeker = new JButton("Job Seeker Management");
        jobSeeker.setPreferredSize(new Dimension(278, 40));
        recruiter = new JButton("Recruiter Management");
        recruiter.setPreferredSize(new Dimension(278, 40));
        job = new JButton("Job Management");
        job.setPreferredSize(new Dimension(278, 40));

        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(jobSeeker, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = buttonInset;

        add(recruiter, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = buttonInset;

        add(job, gridBagConstraints);
    }

    public void viewJobSeekers(ActionListener actionListener) {
        jobSeeker.addActionListener(actionListener);
    }

    public void viewRecruiters(ActionListener actionListener) {
        recruiter.addActionListener(actionListener);
    }

    public void viewJobs(ActionListener actionListener) {
        recruiter.addActionListener(actionListener);
    }
}
