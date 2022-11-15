package View;

import Controller.JobSeekerController;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public AdminFrame() {
        super("Java Swing MVC");
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        JobSeekerForm jobSeekerForm = new JobSeekerForm();
        JobSeekerDetails jobSeekerDetails = new JobSeekerDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Job seeker controller
        new JobSeekerController(jobSeekerForm, jobSeekerDetails);

        // adds view to card layout with unique constraints
        add(jobSeekerForm, "form");
        add(jobSeekerDetails, "Job Seeker details");
        // switch view according to its constraints on click
        jobSeekerForm.viewUsers(e -> cardLayout.show(AdminFrame.this.getContentPane(), "Job Seeker details"));
        jobSeekerDetails.backButton(e -> cardLayout.show(AdminFrame.this.getContentPane(), "form"));

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
