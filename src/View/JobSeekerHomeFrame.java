package View;

import Controller.JobSeekerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobSeekerHomeFrame extends JFrame {

    private CardLayout cardLayout;
    ImageIcon image = new ImageIcon("images/pic1.PNG");

    private JLabel imageLabel;
    private JLabel message;
    private JMenu jobSeekerMenu;
    private JMenuBar homeMenuBar;
    private JMenuItem jobSeekerProfile;
    private JMenuItem recruiterDetails;
    private JMenuItem jobDetails;
    private JMenuItem jMenuItem;

    public JobSeekerHomeFrame() {
        super("Home");
        initComponents();
        imageLabel.setIcon(image);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        cardLayout = new CardLayout();

        JobSeekerForm jobSeekerForm = new JobSeekerForm();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Job seeker controller
        new JobSeekerController(jobSeekerForm);
        add(jobSeekerProfile, "Job Seeker");
        // switch view according to its constraints on click
        jobSeekerForm.viewJobSeekers(e -> cardLayout.show(JobSeekerHomeFrame.this.getContentPane(), "Job Seeker Home"));

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
        /*
        message = new JLabel();
        imageLabel = new JLabel();
        homeMenuBar = new JMenuBar();
        jobSeekerMenu = new JMenu();
        jobSeekerDetails = new JMenuItem();
        recruiterDetails = new JMenuItem();
        jobDetails = new JMenuItem();
        jMenuItem = new JMenuItem();

        jMenuItem.setText("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBackground(new Color(255, 255, 255));
            message.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
            message.setText("Welcome to JSS");

            homeMenuBar.setFont(new Font("Times New Roman", 0, 18)); // NOI18N

            jobSeekerMenu.setText("Job Seeker");
            jobSeekerMenu.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            jobSeekerMenu.setMargin(new Insets(10, 10, 10, 10));

            jobSeekerDetails.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            jobSeekerDetails.setText("Profile");
            jobSeekerDetails.setMargin(new Insets(10, 10, 10, 10));
            jobSeekerDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jobSeekerDetailsActionPerformed(evt);
                }
            });
            jobSeekerMenu.add(jobSeekerDetails);

            jobDetails.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            jobDetails.setText("Job Applications");
            jobDetails.setMargin(new Insets(10, 10, 10, 10));
            jobDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    jobDetailsActionPerformed(evt);
                }
            });
            jobSeekerMenu.add(jobDetails);

            recruiterDetails.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            recruiterDetails.setText("Interview Invites");
            recruiterDetails.setMargin(new Insets(10, 10, 10, 10));
            recruiterDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    recruiterDetailsActionPerformed(evt);
                }
            });
            jobSeekerMenu.add(recruiterDetails);

            homeMenuBar.add(jobSeekerMenu);

            setJMenuBar(homeMenuBar);

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(308, 308, 308)
                                                    .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(403, 403, 403)
                                                    .addComponent(message, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(361, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(133, Short.MAX_VALUE)
                                    .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(message, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114))
            );

            pack();
        }

        private void jobSeekerDetailsActionPerformed(ActionEvent evt) {
            JobSeekerFrame jobSeekerFrame = new JobSeekerFrame();
            jobSeekerFrame.setVisible(true);
            jobSeekerFrame.setLocationRelativeTo(null);
            jobSeekerFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
        }

        private void jobDetailsActionPerformed(ActionEvent evt) {
            JobFrame jobFrame = new JobFrame();
            jobFrame.setVisible(true);
            jobFrame.setLocationRelativeTo(null);
            jobFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
        }

        private void recruiterDetailsActionPerformed(ActionEvent evt) {
            RecruiterFrame recruiterFrame = new RecruiterFrame();
            recruiterFrame.setVisible(true);
            recruiterFrame.setLocationRelativeTo(null);
            recruiterFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
        }
       */
    }
}

