package gui.clientComponents;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Project.project;
import client.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class requestProjGui extends JFrame {
    JLabel nameLabel = new JLabel("Project Name: ");
    JLabel domainLabel = new JLabel("Domain: ");
    JLabel releaseDateLabel = new JLabel("Expected Release Date: ");
    JLabel startDateLabel = new JLabel("Expected Starting Date: ");
    String cl_id;

    JTextField nameTextField = new JTextField(20);
    JTextField domainTextField = new JTextField(20);
    JTextField releaseTextField = new JTextField(20);
    JTextField startTextField = new JTextField(20);

    JPanel title = new JPanel();
    JPanel menu;
    JButton requestButton = new JButton("Request");
    JButton resetButton = new JButton("Reset");

    public requestProjGui(String id) {
        cl_id = id;
        menu = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        menu.add(nameLabel, constraints);

        constraints.gridx = 1;
        menu.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        menu.add(domainLabel, constraints);

        constraints.gridx = 1;
        menu.add(domainTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        menu.add(releaseDateLabel, constraints);

        constraints.gridx = 1;
        menu.add(releaseTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(requestButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(resetButton, constraints);

        add(menu);
        setSize(1280, 1024);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setButtonActions();
    }

    void setButtonActions() {
        requestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                client cli = new client();
                project proj = new project();

                proj.setProjectName(nameTextField.getText());
                proj.setProjectDeadline(releaseTextField.getText());
                proj.setProjectType(domainTextField.getText());
                proj.setClientID(cl_id);

                cli.AddProject(proj);
                dispose();
            }
        });
    }
}
