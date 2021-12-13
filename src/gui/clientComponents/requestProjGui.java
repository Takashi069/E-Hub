package gui.clientComponents;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Project.project;
import client.client;
import gui.clientgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class requestProjGui extends JFrame {
    JLabel nameLabel = new JLabel("Project Name: ");
    JLabel domainLabel = new JLabel("Domain: ");
    JLabel releaseDateLabel = new JLabel("Release Date ( Format: YYYY-MM-DD ): ");
    JLabel startDateLabel = new JLabel("Expected Starting Date: ");
    JLabel descriptionLabel = new JLabel("Project Description");
    String cl_id;

    JTextField nameTextField = new JTextField(20);;
    JTextField releaseTextField = new JTextField(20);
    JTextField startTextField = new JTextField(20);
    JTextArea descriptionTextField = new JTextArea(10, 50);

    String[] domainChoices = { "WEB", "ANDROID", "SCIENTIFIC", "BUSINESS", "MEDICAL",
            "INDUSTRIAL & PROCESS CONTROL", "SYSTEMS SOFTWARE", "TOOL DEVELOPMENT(COMPILERS, ASSEMBLERS)" };
    JComboBox<String> domainOptions;

    JPanel title = new JPanel();
    JPanel menu;
    JButton requestButton = new JButton("Request");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Go Back");

    public requestProjGui(String id) {
        cl_id = id;
        domainOptions = new JComboBox<String>(domainChoices);
        domainOptions.setBackground(Color.WHITE);
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
        menu.add(domainOptions, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        menu.add(descriptionLabel, constraints);

        descriptionTextField.setLineWrap(true);
        constraints.gridx = 1;
        menu.add(descriptionTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        menu.add(releaseDateLabel, constraints);

        constraints.gridx = 1;
        menu.add(releaseTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(requestButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(resetButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(backButton, constraints);

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
                proj.setProjectLog(descriptionTextField.getText());
                proj.setProjectDeadline(releaseTextField.getText());
                proj.setProjectType(domainOptions.getItemAt(domainOptions.getSelectedIndex()));
                proj.setClientID(cl_id);
                cli.AddProject(proj);
                dispose();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                nameTextField.setText("");
                releaseTextField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                dispose();
            }
        });

    }
}

class cdriver {
    public static void main(String[] args) {
        new requestProjGui("CLE001");
    }
}
