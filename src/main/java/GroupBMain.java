package main.java;

import View.HomeFrame;

import javax.swing.*;
import java.awt.*;

public class GroupBMain{
    public static void main(String[] args) {
    // runs in AWT thread
        HomeFrame homeFrame = new HomeFrame();
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setDefaultCloseOperation(3);
        homeFrame.setVisible(true);
    }
}