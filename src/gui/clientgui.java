package gui;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    JButton viewProjButton;
    JButton addProjButton;
    secret path = new secret();
    JLabel background=new JLabel(new ImageIcon(path.frame_bg));
    ImageIcon viewProjectsIcon= new ImageIcon(path.view_bg);
    ImageIcon requestProjectsIcon= new ImageIcon(path.req_bg);

    public clientgui(String id) {
        frame.setSize(1280, 1024);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(75);
        background.setLayout(layout);

        viewProjButton = new JButton(viewProjectsIcon);
        viewProjButton.setOpaque(false);
        viewProjButton.setContentAreaFilled(false);
        viewProjButton.setBorderPainted(false);

        addProjButton = new JButton(requestProjectsIcon);
        addProjButton.setOpaque(false);
        addProjButton.setContentAreaFilled(false);
        addProjButton.setBorderPainted(false);


        background.add(viewProjButton);
        background.add(addProjButton);
        title.add(label);
        background.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        frame.add(title, BorderLayout.NORTH);
        frame.add(background, BorderLayout.CENTER);
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
                new viewProjGui(id);
                // req.setVisible(true);
                c.setVisible(false);
            }
        });
    }

}

class Driver123{
    public static void main(String[] args) {
        new clientgui("CLI001");
    }
}
