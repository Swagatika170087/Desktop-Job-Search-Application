package View;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public AdminFrame() {
        super("Administrator Login");
        initComponents();
    }
    private void initComponents(){
        cardLayout = new CardLayout();
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize Admin controller
        new AdminController(adminLoginForm);

        // adds view to card layout with unique constraints
        add(adminLoginForm, "Administrator Login");
        // switch view according to its constraints on click
        adminLoginForm.loginAdmin(e -> cardLayout.show(AdminFrame.this.getContentPane(), "Administrator Login"));

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/images/pic1.png");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1000;
        int FRAME_HEIGHT = 600;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
