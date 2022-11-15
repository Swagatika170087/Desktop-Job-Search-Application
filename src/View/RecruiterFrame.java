package View;

import Controller.JobSeekerController;
import Controller.RecruiterController;

import javax.swing.*;
import java.awt.*;

public class RecruiterFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public RecruiterFrame() {
        super("Java Swing MVC");
        initComponents();
    }
    private void initComponents() {
        cardLayout = new CardLayout();
        RecruiterForm recruiterForm = new RecruiterForm();
        RecruiterDetails recruiterDetails = new RecruiterDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Job seeker controller
        new RecruiterController(recruiterForm, recruiterDetails);

        // adds view to card layout with unique constraints
        add(recruiterForm, "form");
        add(recruiterDetails, "Recruiter details");
        // switch view according to its constraints on click
        recruiterForm.viewUsers(e -> cardLayout.show(RecruiterFrame.this.getContentPane(), "Recruiter details"));
        recruiterDetails.backButton(e -> cardLayout.show(RecruiterFrame.this.getContentPane(), "form"));

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
