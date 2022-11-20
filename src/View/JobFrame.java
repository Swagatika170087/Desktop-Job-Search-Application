package View;

import Controller.JobController;
import Controller.JobSeekerController;

import javax.swing.*;
import java.awt.*;

public class JobFrame extends JFrame{
    // Card layout for switching view
    private CardLayout cardLayout;

    public JobFrame() {
        super("Java Swing MVC");
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        JobForm jobForm = new JobForm();
        JobDetails jobDetails = new JobDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Job seeker controller
        new JobController(jobForm, jobDetails);

        // adds view to card layout with unique constraints
        add(jobForm, "form");
        add(jobDetails, "Job Seeker details");
        // switch view according to its constraints on click
        jobForm.viewJobs(e -> cardLayout.show(JobFrame.this.getContentPane(), "Job Seeker details"));
        jobDetails.backButton(e -> cardLayout.show(JobFrame.this.getContentPane(), "form"));

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/images/download.jpeg");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
