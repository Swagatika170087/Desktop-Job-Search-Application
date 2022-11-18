package View;

import Controller.JobSeekerController;

import javax.swing.*;
import java.awt.*;

public class JobSeekerFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public JobSeekerFrame() {
        super("Java Swing MVC");
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        JobSeekerLoginForm jobSeekerLoginForm = new JobSeekerLoginForm();
        JobSeekerDetails jobSeekerDetails = new JobSeekerDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Job seeker controller
        new JobSeekerController(jobSeekerLoginForm);

        // adds view to card layout with unique constraints
        add(jobSeekerLoginForm, "Job Seeker Login");
        // switch view according to its constraints on click
        jobSeekerLoginForm.loginJobSeeker(e -> cardLayout.show(JobSeekerFrame.this.getContentPane(), "Job Seeker Login"));

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
