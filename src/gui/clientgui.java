package gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.clientComponents.requestProjGui;
import gui.clientComponents.viewProjGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class clientgui extends JFrame {
    JFrame frame = new JFrame("Client Dashboard");
    JPanel title = new JPanel();
    JPanel menu = new JPanel();
    JLabel label = new JLabel("Welcome Client");
    JButton viewProjButton = new JButton("View Projects");
    JButton addProjButton = new JButton("Request Project");

    public clientgui(String id) {
        frame.setSize(1280, 1024);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2, 0);
        layout.setVgap(50);
        menu.setLayout(layout);
        menu.add(viewProjButton);
        menu.add(addProjButton);
        title.add(label);
        menu.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        frame.add(title, BorderLayout.NORTH);
        frame.add(menu, BorderLayout.CENTER);
        setActions(this, id);
    }

    void setActions(clientgui c, String id) {
        addProjButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                requestProjGui req = new requestProjGui(id);
                req.setVisible(true);
                c.setVisible(false);
            }
        });
        viewProjButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                viewProjGui req = new viewProjGui();
               // req.setVisible(true);
                c.setVisible(false);
            }
        });
    }

}
