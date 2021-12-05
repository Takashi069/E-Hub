/* package gui.adminComponents;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import employee.employee;
import client.client;


public class addClientGUI {
    
    admingui adg;

    void addClientGUIfunc(){
        adg.addClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;//column
        gbc.gridy = 0;//row   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20,20,20,0);    
        gbc.ipady = 10; // height of the grid 
        adg.addClient.add(adg.name,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 40;
        adg.addClient.add(adg.nameTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.streetName,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.streetNameTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.locality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.localityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.District,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.DistrictTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.state,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.stateTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.pincode,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.pincodeTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.nationality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.nationalityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.dob,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.dobTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.Company,gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.companyTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        adg.addClient.add(adg.submit2,gbc);
    }

    class handleInputClient implements ActionListener{

        public void actionPerformed(ActionEvent a){
            adg.frame.remove(adg.cliMenu);
            adg.heading.setText("Input Client Information");
            new addClientGUI();
            adg.frame.add(adg.addClient,BorderLayout.CENTER);
            //frame.add(submit,BorderLayout.SOUTH);
        }
    }
} */