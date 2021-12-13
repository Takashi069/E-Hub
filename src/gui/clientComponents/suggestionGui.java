package gui.clientComponents;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Project.project;
import client.client;
import gui.clientComponents.requestProjGui;
import gui.clientComponents.viewProjGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class suggestionGui extends JFrame {
    JFrame frame = new JFrame("Client Menu");
    JLabel projectLog = new JLabel("Project log: ");
    // JLabel domainLabel = new JLabel("Domain: ");
    JLabel suggestionLabel = new JLabel("Enter Your Suggestions Here: ");
    JLabel startDateLabel = new JLabel("Expected Starting Date: ");
    String cl_id;
    JTextArea Projectlog_area = new JTextArea(20, 50);

    JTextArea Suggestion_area = new JTextArea(20, 50);
    // JTextField startTextField = new JTextField(20);
    // JComboBox<String> domainOptions;

    JPanel title = new JPanel();
    JPanel menu;
    JButton requestButton = new JButton("Request");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Go Back");
    project ProjectObj;
    String project_id;
    String log;
    String final_log;

    suggestionGui(project pro) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ProjectObj = pro;
        project_id = ProjectObj.getProjectID();
        log = ProjectObj.retrieveLog(project_id);
        final_log = log.replaceAll("\\\\n", System.getProperty("line.separator"));
        final_log = final_log.replaceAll("#", System.getProperty("line.separator"));
        // domainOptions.setBackground(Color.WHITE);
        menu = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        Projectlog_area.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        menu.add(projectLog, constraints);

        constraints.gridx = 1;
        Projectlog_area.setLineWrap(true);
        Projectlog_area.setText(final_log);
        menu.add(Projectlog_area, constraints);

        /*
         * constraints.gridx = 0;
         * constraints.gridy = 1;
         * menu.add(domainLabel, constraints);
         */

        // constraints.gridx = 1;
        // menu.add(domainOptions, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        menu.add(suggestionLabel, constraints);

        constraints.gridx = 1;
        Suggestion_area.setLineWrap(true);
        menu.add(Suggestion_area, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        if (pro.getProjectStatus().equals("CHANGES REQUESTED")) {
            requestButton.setEnabled(false);
        }
        menu.add(requestButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        menu.add(resetButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
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
                // project proj = new project();

                // proj.setProjectLog(Projectlog_area.getText());
                ProjectObj.setProjectLog(Suggestion_area.getText());
                // proj.setProjectType(domainOptions.getItemAt(domainOptions.getSelectedIndex()));
                // proj.setClientID(cl_id);
                cli.suggestChanges(ProjectObj);
                dispose();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                // Projectlog_area.setText("");
                Suggestion_area.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                dispose();
            }
        });

    }

    public static void main(String args[]) {
        project pro = new project();
        new suggestionGui(pro);
    }
}

/*
 * public requestProjGui(String id) {
 * cl_id = id;
 * domainOptions = new JComboBox<String>(domainChoices);
 */
