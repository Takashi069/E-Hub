package gui.clientComponents;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import assets.getAssets;
import client.client;
import gui.secret;
import Project.project;

public class viewProjGui {
    JFrame frame = new JFrame("Client Menu");
    getAssets path = new getAssets();
    JPanel cliMenu = new JPanel();
    JLabel viewProject = new JLabel(new ImageIcon(path.frame_bg));
    JLabel heading = new JLabel("Welcome Client");
    String[] emptyArray = { "null" };
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Project Name: ");
    JLabel dynamicName = new JLabel();
    JLabel status = new JLabel("Status of the Project");
    JLabel statusLabel = new JLabel();
    String[] id_list;
    String[] name_list;
    JButton suggest = new JButton(new ImageIcon(path.suggest_btn));
    JButton backButton = new JButton(new ImageIcon(path.back_btn));
    JLabel descriptionLabel = new JLabel("Description");
    JTextArea descriptionTextField = new JTextArea(10, 50);
    String project_status;

    JComboBox<String> allID = new JComboBox<String>(emptyArray);
    String ClientID = "";

    public viewProjGui(String cli_id) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClientID = cli_id;
        project pro = new project();
        client cli = new client();
        cli.ProjectList(pro, ClientID);
        id_list = cli.getPersonIdList();
        name_list = cli.getPersonNameList();
        viewProject.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID = new JComboBox<String>(name_list);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        id.setForeground(Color.WHITE);
        viewProject.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID.setForeground(Color.WHITE);
        allID.setBackground(Color.DARK_GRAY);
        allID.setBorder(new LineBorder(Color.DARK_GRAY));
        viewProject.add(allID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        name.setForeground(Color.WHITE);
        viewProject.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dynamicName.setForeground(Color.WHITE);
        viewProject.add(dynamicName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descriptionLabel.setForeground(Color.WHITE);
        viewProject.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descriptionTextField.setLineWrap(true);
        descriptionTextField.setEditable(false);
        descriptionTextField.setForeground(Color.WHITE);
        descriptionTextField.setCaretColor(Color.WHITE);
        descriptionTextField.setBackground(Color.DARK_GRAY);
        descriptionTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        viewProject.add(descriptionTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        status.setForeground(Color.WHITE);
        viewProject.add(status, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        statusLabel.setForeground(Color.WHITE);
        viewProject.add(statusLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        suggest.setOpaque(false);
        suggest.setContentAreaFilled(false);
        suggest.setBorderPainted(false);
        viewProject.add(suggest, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        viewProject.add(backButton, gbc);

        suggest.addActionListener(new handleSuggestChanges());
        allID.addActionListener(new handleShowDetails());
        frame.setSize(1280, 1024);
        frame.add(viewProject);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                frame.dispose();
            }
        });

    }

    private void updateviewProjectGUI(project P) {
        dynamicName.setText(P.getProjectName());
        statusLabel.setText(P.getProjectStatus());
        project_status = P.getProjectStatus();
        String full_log = P.getProjectLog();
        String description = full_log.split("#")[0].replaceAll("\\\\n", System.getProperty("line.separator"));
        descriptionTextField.setText(description);
        // dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }
    
    class handleShowDetails implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            project pro = new project();
            client cli = new client();
            pro.setProjectID((String) id_list[allID.getSelectedIndex()]);
            pro = cli.showPrimaryDetails(pro);
            updateviewProjectGUI(pro);
            // System.out.println(pro.getProjectName());

        }
    }

    class handleSuggestChanges implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            /*
             * admin ad = new admin();
             * client cli = new client();
             * int input = JOptionPane.showConfirmDialog(frame,
             * "Confirm Deletion of Person", "WARNING",
             * JOptionPane.YES_NO_OPTION);
             * // 0->Yes, 1->No
             * 
             * project pro = new project();
             * pro.setProjectID((String) id_list[allID.getSelectedIndex()]);
             * if (input == 0) {
             * cli.removeProject(pro);
             * JOptionPane.showMessageDialog(frame, "Data Deleted", "Info",
             * JOptionPane.PLAIN_MESSAGE);
             * }
             * frame.dispose();
             * new viewProjGui(ClientID);
             */
            project pro = new project();
            pro.setProjectID((String) id_list[allID.getSelectedIndex()]);
            pro.setProjectStatus(project_status);
            System.out.println(id_list[allID.getSelectedIndex()]);
            new suggestionGui(pro);
        }
    }
}

class Driver123 {
    public static void main(String[] args) {
        new viewProjGui("CLI001");
    }
}
