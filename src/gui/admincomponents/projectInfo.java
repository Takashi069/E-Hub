package gui.admincomponents;
import javax.swing.*;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import exceptions.noData;
import gui.admingui;
import Project.project;

public class projectInfo {

    JFrame frame = new JFrame("Modification Approval Menu");
    JPanel cliMenu = new JPanel();
    JPanel viewProject = new JPanel();
    JLabel heading = new JLabel("Welcome Admin");
    String[] emptyArray = { "null" };
    JLabel id = new JLabel("Project ID: ");
    JLabel name = new JLabel("Project Name: ");
    JLabel dynamicName = new JLabel();
    JLabel status = new JLabel("Status of the Project");
    JLabel statusLabel = new JLabel();
    JButton approve = new JButton("Approve Modifications");
    JButton reject = new JButton("Reject Modifications");
    JButton backButton = new JButton("Go Back");
    JLabel descriptionLabel = new JLabel("Project Log");
    JTextArea descriptionTextField = new JTextArea(10, 50);
    String project_status;

    JComboBox<String> allID = new JComboBox<String>(emptyArray);
    String[] projID = null;

    public projectInfo() throws noData {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin ad = new admin();
        projID = ad.ProjectListChangesRequested() ;   
        if(projID == null)
            throw new noData();     
        viewProject.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID = new JComboBox<String>(projID);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID.setBackground(Color.white);
        viewProject.add(allID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(dynamicName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descriptionTextField.setLineWrap(true);
        descriptionTextField.setEditable(false);
        viewProject.add(descriptionTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(status, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(statusLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(approve, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.CENTER;
        viewProject.add(reject,gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        viewProject.add(backButton, gbc);

        approve.addActionListener(new handleApproveChanges());
        allID.addActionListener(new handleShowDetails());
        reject.addActionListener(new handleRejectChanges());
        frame.setSize(960, 640);
        frame.add(viewProject);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                frame.dispose();
                new admingui();
            }
        });

    }

    private void updateviewProjectGUI(project P) {
        dynamicName.setText(P.getProjectName());
        statusLabel.setText(P.getProjectStatus());
        project_status = P.getProjectStatus();
        String full_log = P.getProjectLog();
        String description = full_log.replaceAll("\\\\n", System.getProperty("line.separator"));
        descriptionTextField.setText(description);
        // dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }
    
    private int logPrompt(project P){
        admin adm = new admin();
        String message = JOptionPane.showInputDialog(frame, "Admin Log Message", "", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(message);
        if(message!=null && message.length()>0){
            adm.addProjectLog(P, message);
            return 1;
        }else{
            return 0;
        }
    }

    class handleShowDetails implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            project pro = new project();
            admin ad = new admin();
            pro.setProjectID((String)allID.getSelectedItem());
            pro = ad.showPrimaryDetails(pro);
            updateviewProjectGUI(pro);
            // System.out.println(pro.getProjectName());

        }
    }

    class handleApproveChanges implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            project pro = new project();
            admin ad = new admin();
            pro.setProjectID((String)allID.getSelectedItem());
            int output = logPrompt(pro);
            if(output == 1){
                ad.ProjectChanges(pro,"CHANGES ACCEPTED");
                JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to update", "Info", JOptionPane.PLAIN_MESSAGE);

            }
            frame.repaint();
        }
    }
    class handleRejectChanges implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            project pro = new project();
            admin ad = new admin();
            pro.setProjectID((String)allID.getSelectedItem());
            int output = logPrompt(pro);
            if(output == 1){
                ad.ProjectChanges(pro,"CHANGES REJECTED");
                JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to update", "Info", JOptionPane.PLAIN_MESSAGE);

            }
            frame.repaint();
        }
    }
}

class Driver123 {
    public static void main(String[] args) {
        //new projectInfo();
    }
}
