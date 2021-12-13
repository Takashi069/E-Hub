package gui;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import client.client;
import admin.admin;

public class ClientReportGui {
    JFrame frame = new JFrame();
    JPanel remClient = new JPanel();
    JPanel display = new JPanel();
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name: ");
    JLabel dob = new JLabel("DOB ( Format: YYYY-MM-DD )");
    JLabel Company = new JLabel("Company");
    JLabel totalOrders = new JLabel("Total Orders");
    JLabel heading = new JLabel("something");
    JTextField dynamicID = new JTextField();
    JTextField dynamicName = new JTextField();
    JTextField dynamicDOB = new JTextField();
    JTextField dynamicCompany = new JTextField();
    JTextField dynamicTotalOrder = new JTextField();

    JButton backButton = new JButton("Back");

    String[] emptyArray = { "null" };
    JComboBox<String> allID2 = new JComboBox<String>(emptyArray);

    CardLayout card;

 /*    public ClientReportGui() {
        card = new CardLayout();
        display.setLayout(card);
        frame.setSize(960,640);
        frame.setVisible(true);
        display.add(remClient, "removeClientMenu");
        frame.add(display);
        frame.setSize(1280, 1024);
     //   frame.add(remClient);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
} */

public ClientReportGui() {
        card = new CardLayout();
        display.setLayout(card);
        frame.setSize(960,640);
        display.add(remClient, "removeClientMenu");
        frame.add(display);
     //   frame.add(remClient);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin ad = new admin();
        client cli = new client();
        String[] ID = ad.PersonList(cli);
        remClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID2.removeAllItems();
        for (String id : ID) {
            allID2.addItem(id);
        }
        gbc.ipadx = 100;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID2.setBackground(Color.white);
        remClient.add(allID2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicName, gbc);
        dynamicName.setEditable(false);
        dynamicName.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicDOB, gbc);
        dynamicDOB.setEditable(false);
        dynamicDOB.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(Company, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicCompany, gbc);
        dynamicCompany.setEditable(false);
        dynamicCompany.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(totalOrders, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicTotalOrder, gbc);
        dynamicCompany.setEditable(false);
        dynamicCompany.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 5;
        remClient.add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //  remClient.add(remove1,gbc);
        allID2.addActionListener(new handleShowCliDetails());
        backButton.addActionListener(new goToMainMenu());
        frame.setVisible(true);

    }
    class goToMainMenu implements ActionListener{
        public void actionPerformed(ActionEvent a){
            frame.dispose();
            new admingui(); 
            //disposing and re-creating the frame fixed a lot of bugs in the back button part of the GUI such as the showProjectDetails 
        }
    }
    private void updateRemGUI(client C) {
        dynamicName.setText(C.getName());
        dynamicDOB.setText(C.getDOB());
        dynamicCompany.setText(C.getCompany());
        //System.out.println("UpdateRemCliGUI: " + C.getName());
        dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }

    class handleShowCliDetails implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            admin ad = new admin();
            client cli = new client();
            cli.setID((String) allID2.getSelectedItem());
            cli = ad.showPrimaryDetails(cli);
            //System.out.println("\nClient GUI Details called\n");
            updateRemGUI(cli);
        }
    }
    /* class handleRemoveClient implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Remove Client");
            remClientGUI();
            card.show(display,"removeClientMenu");
        }
    } */
}
     /* class handleRemoveClient implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Remove Client");
            remClientGUI();
            card.show(display,"removeClientMenu");
        }
    } */
     
    class newDriverclass {
        public static void main(String[] args) {
            new ClientReportGui();
            //adg.logPrompt();
        }
    }

