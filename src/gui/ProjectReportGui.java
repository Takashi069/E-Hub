package gui;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Project.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import client.client;
import admin.admin;

public class ProjectReportGui {
    JFrame frame = new JFrame();
    JPanel display = new JPanel();
    JPanel projectApprove = new JPanel();
    JPanel projectUpdateStatus = new JPanel();
    JLabel id = new JLabel("ID");
    JLabel projectName = new JLabel("Project Name");
    JTextField dynamicProjectNameTextField = new JTextField();
    //JLabel ProjectStatus = new JLabel("Project Status Name");
   // JTextField dynamicProjectStatusTextField = new JTextField();
    JLabel clientID = new JLabel("Client ID");
    JTextField dynamicClientIDTextField = new JTextField();
    JLabel deadline = new JLabel("Deadline Date(YYYY-MM-DD)");
    JTextField dynamicDeadlineTextField = new JTextField();
    JButton backButton = new JButton("Back");
    String[] emptyArray = { "null" };
    final String[] statusChoices = { "APPROVED", "REJECTED", "DEADLINE DATE CHANGED", "CHANGES REJECTED",
            "CHANGES APPROVED", "WORK IN PROGRESS", "TESTING", "COMPLETED", "PAID" };
            JLabel Status = new JLabel("Project Status");
            JTextField dynamicStatusTextField = new JTextField();
    JLabel descriptionLabel = new JLabel("Project Log");
    JTextArea descriptionTextField = new JTextArea(10, 50);
    JComboBox<String> allID2 = new JComboBox<String>(emptyArray);
    JComboBox<String> allID3 = new JComboBox<String>(emptyArray);
    JComboBox<String> statusComboBox = new JComboBox<String>(statusChoices);

    public ProjectReportGui() {
        frame.setSize(960, 640);
        frame.add(display);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.add(projectApprove, "projectApproveMenu");
        admin a = new admin();
        String[] projectList = a.ProjectListNotApproved();
        projectApprove.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID3.setBackground(Color.WHITE);
        allID3.removeAllItems();
        for (String id : projectList) {
            allID3.addItem(id);
        }
        allID3.setSelectedIndex(0);
        System.out.println("Printing selected index of allID3:" + allID3.getSelectedIndex());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID2.setBackground(Color.white);
        projectApprove.add(allID3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(projectName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(dynamicProjectNameTextField, gbc);
        dynamicProjectNameTextField.setEditable(false);
        dynamicProjectNameTextField.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(clientID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(dynamicClientIDTextField, gbc);
        dynamicClientIDTextField.setEditable(false);
        dynamicClientIDTextField.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(deadline, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(dynamicDeadlineTextField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(Status, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(dynamicStatusTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descriptionTextField.setLineWrap(true);
        descriptionTextField.setEditable(false);
        projectApprove.add(descriptionTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        projectApprove.add(backButton, gbc);

        /* gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(Approve,gbc); */
        allID3.addActionListener(new handleShowProjectDetails());
        // Approve.addActionListener(new handleStatusChange());
        frame.setVisible(true);
        backButton.addActionListener(new goToMainMenu());
    }

    private void updateProjectGUI(project P) {

        int index = 0;
        String item = P.getProjectStatus();
        System.out.println("item: " + item);

        //  if(item == null)
        //   throw new noData();    
        for (int i = 0; i < statusChoices.length; i++) {
            if (item.compareToIgnoreCase(statusChoices[i]) == 0) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        dynamicProjectNameTextField.setText(P.getProjectName());
        System.out.println(P.getClientID()); //--> Shows NULL here
        dynamicClientIDTextField.setText(P.getClientID());
        //System.out.println("UpdateRemEmpGUI: " + p.getName());
        //dynamicProjectStatusTextFieldsetText(P.getProjectStatus());
        dynamicStatusTextField.setText(P.getProjectStatus());
        dynamicDeadlineTextField.setText(P.getProjectDeadline());
        String full_log = P.getProjectLog();
        String description = full_log.replaceAll("\\\\n", System.getProperty("line.separator"));
        descriptionTextField.setText(description);
        statusComboBox.setSelectedIndex(index);
        projectUpdateStatus.repaint();
    }

    class handleShowProjectDetails implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            admin ad = new admin();
            project p = new project();
            System.out.println("In handleShowProjectDetails");
            p.setProjectID((String) allID3.getSelectedItem());
            System.out.println("Project ID: " + p.getProjectID());
            p = ad.showPrimaryDetails(p);
            updateProjectGUI(p);

        }
    }
    class goToMainMenu implements ActionListener{
        public void actionPerformed(ActionEvent a){
            frame.dispose();
            new admingui(); 
            //disposing and re-creating the frame fixed a lot of bugs in the back button part of the GUI such as the showProjectDetails 
        }
    }
}
class newDrissssssssverclass {
        public static void main(String[] args) {
            new ProjectReportGui();
            //adg.logPrompt();
        }
    }

