package View;

import main.java.GroupBMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {
    ImageIcon image = new ImageIcon("images/pic1.PNG");

    private JLabel imageLabel;
    private JLabel message;
    private JMenu jobSeekerMenu;
    private JMenu recruiterMenu;
    private JMenu adminMenu;
    private JMenuBar homeMenuBar;
    private JMenuItem adminLogin;
    private JMenuItem recruiterLogin;
    private JMenuItem jobSeekerLogin;
    private JMenuItem recruiterRegister;
    private JMenuItem jobSeekerRegister;
    private JMenuItem jMenuItem1;

    public HomeFrame() {
        super("Java Swing MVC");
        initComponents();
        imageLabel.setIcon(image);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        message = new JLabel();
        imageLabel = new JLabel();
        homeMenuBar = new JMenuBar();
        jobSeekerMenu = new JMenu();
        jobSeekerLogin = new JMenuItem();
        jobSeekerRegister = new JMenuItem();
        recruiterMenu = new JMenu();
        recruiterRegister = new JMenuItem();
        recruiterLogin = new JMenuItem();
        adminMenu = new JMenu();
        adminLogin = new JMenuItem();
        jMenuItem1 = new JMenuItem();

        jMenuItem1.setText("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        message.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        message.setText("Welcome to the Job Portal System");

        homeMenuBar.setFont(new Font("Times New Roman", 0, 18)); // NOI18N

        jobSeekerMenu.setText("Job Seeker");
        jobSeekerMenu.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jobSeekerMenu.setMargin(new Insets(10, 10, 5, 10));

        jobSeekerRegister.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jobSeekerRegister.setText("Register");
        jobSeekerRegister.setMargin(new Insets(10, 10, 10, 10));
        jobSeekerRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jobSeekerRegisterActionPerformed(evt);
            }
        });
        jobSeekerMenu.add(jobSeekerRegister);

        jobSeekerLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jobSeekerLogin.setText("Login");
        jobSeekerLogin.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jobSeekerLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobSeekerLoginActionPerformed(evt);
            }
        });
        jobSeekerMenu.add(jobSeekerLogin);

        homeMenuBar.add(jobSeekerMenu);

        recruiterMenu.setText("Recruiter");
        recruiterMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recruiterMenu.setMargin(new java.awt.Insets(10, 10, 10, 10));

        recruiterRegister.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recruiterRegister.setText("Register");
        recruiterRegister.setMargin(new java.awt.Insets(10, 10, 5, 10));
        recruiterRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recruiterRegisterActionPerformed(evt);
            }
        });
        recruiterMenu.add(recruiterRegister);

        recruiterLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recruiterLogin.setText("Login");
        recruiterLogin.setMargin(new java.awt.Insets(5, 10, 10, 10));
        recruiterLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recruiterLoginActionPerformed(evt);
            }
        });
        recruiterMenu.add(recruiterLogin);

        homeMenuBar.add(recruiterMenu);

        adminMenu.setText("Admin");
        adminMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adminMenu.setMargin(new java.awt.Insets(10, 10, 10, 10));

        adminLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adminLogin.setText("Login Admin");
        adminLogin.setMargin(new java.awt.Insets(10, 10, 10, 10));
        adminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                adminLoginActionPerformed(evt);
            }
        });
        adminMenu.add(adminLogin);

        homeMenuBar.add(adminMenu);

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

    private void jobSeekerRegisterActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JobSeekerFrame jobSeekerFrame = new JobSeekerFrame();
        jobSeekerFrame.setVisible(true);
        jobSeekerFrame.setLocationRelativeTo(null);
        jobSeekerFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
    }

    private void jobSeekerLoginActionPerformed(ActionEvent evt) {//GEN-FIRST:event_loginjsbuttonActionPerformed
        // TODO add your handling code here:
        JobSeekerFrame  jobSeekerFrame= new JobSeekerFrame();
        jobSeekerFrame.setVisible(true);
        jobSeekerFrame.setLocationRelativeTo(null);
        jobSeekerFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
    }

    private void recruiterRegisterActionPerformed(ActionEvent evt) {//GEN-FIRST:event_regcbuttonActionPerformed
        // TODO add your handling code here:
        RecruiterFrame recruiterFrame = new RecruiterFrame();
        recruiterFrame.setVisible(true);
        recruiterFrame.setLocationRelativeTo(null);
        recruiterFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
    }

    private void recruiterLoginActionPerformed(ActionEvent evt) {//GEN-FIRST:event_logincbuttonActionPerformed
        // TODO add your handling code here:
        RecruiterFrame recruiterFrame = new RecruiterFrame();
        recruiterFrame.setVisible(true);
        recruiterFrame.setLocationRelativeTo(null);
        recruiterFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
    }

    private void adminLoginActionPerformed(ActionEvent evt) {//GEN-FIRST:event_loginabuttonActionPerformed
        // TODO add your handling code here:
        AdminFrame adminFrame = new AdminFrame();
        adminFrame.setVisible(true);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE  );
    }

    public static void main(String args[])
    {
    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
        public void run() {
            new HomeFrame().setVisible(true);
        }
    });
}
}
