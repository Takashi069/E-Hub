package gui.clientComponents;

import javax.swing.*;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import client.client;
import Project.project;

public class viewProjGui {

    JFrame frame = new JFrame("Client Menu");
    JPanel cliMenu = new JPanel();
    JPanel viewProject = new JPanel();
    JLabel heading = new JLabel("Welcome Client");
    String[] emptyArray = { "null" };
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Project Name: ");
    JLabel dynamicName = new JLabel();
    JLabel Company = new JLabel("Status of the Project");
    JLabel dynamicCompany = new JLabel();
    String[] id_list;
    String[] name_list;
    JButton remove1 = new JButton("Suggest Changes");
    JButton backButton = new JButton("Go Back");

    JComboBox<String> allID = new JComboBox<String>(emptyArray);
    String ClientID = "";

    public viewProjGui(String cli_id) {
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
        viewProject.add(Company, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(dynamicCompany, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewProject.add(remove1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        viewProject.add(backButton, gbc);

        remove1.addActionListener(new handleRemoveProject());
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
        dynamicCompany.setText(P.getProjectStatus());
        // dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }
    /*
     * class handleRemoveClient implements ActionListener {
     * public void actionPerformed(ActionEvent a) {
     * admin ad = new admin();
     * client cli = new client();
     * frame.remove(cliMenu);
     * heading.setText("Remove Client");
     * // remClientGUI();
     * frame.add(remClient, BorderLayout.CENTER);
     * }
     * }
     */

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

    class handleRemoveProject implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            /* admin ad = new admin();
            client cli = new client();
            int input = JOptionPane.showConfirmDialog(frame, "Confirm Deletion of Person", "WARNING",
                    JOptionPane.YES_NO_OPTION);
            // 0->Yes, 1->No
            
            project pro = new project();
            pro.setProjectID((String) id_list[allID.getSelectedIndex()]);
            if (input == 0) {
                cli.removeProject(pro);
                JOptionPane.showMessageDialog(frame, "Data Deleted", "Info", JOptionPane.PLAIN_MESSAGE);
            } 
            frame.dispose();
            new viewProjGui(ClientID);*/
            project pro = new project();
            pro.setProjectID((String) id_list[allID.getSelectedIndex()]);
           System.out.println(id_list[allID.getSelectedIndex()]);
            new suggestionGui(pro);  
        }
    }
}
class Driver123{
    public static void main(String[] args) {
        new viewProjGui("CLE001");
    }
}
