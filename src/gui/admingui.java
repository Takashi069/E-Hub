package gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class admingui{
    JFrame frame = new JFrame("Admin Menu");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel label = new JLabel("Welcome Administrator");
    JButton empButton = new JButton("Manage Employees");
    JButton cliButton = new JButton("Manage Clients");
    

    public admingui(){
        frame.setSize(1280,1024);
        frame.setVisible(true);
        p1.setLayout(new GridLayout(2,0));
        p1.add(empButton);
        p1.add(cliButton);
        p1.setBackground(Color.BLACK);
        p2.add(label);

        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Driver{
    public static void main(String[] args) {
        new admingui();
    }
}