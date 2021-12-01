package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import admin.admin;
import employee.employee;
import client.client;

public class admingui{
    JFrame frame = new JFrame("Admin Menu");
    JFrame testing  = new JFrame("Testing");
    
    JPanel mainMenu = new JPanel();
    JPanel menuHeadingPanel = new JPanel();
    JPanel cliMenu = new JPanel();
    JPanel empMenu = new JPanel();
    JPanel addClient = new JPanel();
    JPanel addEmp = new JPanel();

    JLabel heading = new JLabel("Welcome Administrator");
    JLabel name = new JLabel("Name: ");
    JLabel streetName = new JLabel("Street Address: ");
    JLabel locality = new JLabel("Locality: ");
    JLabel District = new JLabel("District: ");
    JLabel state = new JLabel("State: ");
    JLabel pincode = new JLabel("PINCODE: ");
    JLabel nationality = new JLabel("Nationality: ");
    JLabel dob = new JLabel("DOB ( Format: YYYY-MM-DD ): ");
    JLabel experience = new JLabel("Experience (In Years)");
    JLabel domain = new JLabel("Specialisation Domain");

    
    JButton empButton = new JButton("Manage Employees");
    JButton cliButton = new JButton("Manage Clients");
    JButton proButton = new JButton("Manage Projects");
    
    JButton addCliButton = new JButton("Add New Clients");
    JButton addEmplButton = new JButton("Add New Employees");
    JButton submit = new JButton("Submit");
    
    JButton removeCliButton = new JButton("Remove Clients");
    JButton removeEmpButton = new JButton("Remove Employee");

    JTextField nameTextField = new JTextField("Sherlock Holmes");
    JTextField streetNameTextField = new JTextField("221B");
    JTextField localityTextField = new JTextField("Baker Street");
    JTextField DistrictTextField = new JTextField("Central London");
    JTextField stateTextField = new JTextField("London");
    JTextField pincodeTextField = new JTextField("125462");
    JTextField nationalityTextField = new JTextField("UK");
    JTextField dobTextField = new JTextField("1969-10-24");
    JTextField experienceTextField = new JTextField("12");
    
    //It is used to create a drop down menu of the various domains
    JComboBox<String> domainComboBox;

    

    //frame has BORDERLAYOUT by default
    public admingui(){
        frame.setSize(1280,1024);
        frame.setVisible(true);
       /*  testing.setSize(1280,1024);
        testing.setVisible(true); */

        //GridLayout(rows, columns, horizontal gap, vertical gap)
        mainMenu.setLayout(new GridLayout(3,0,0,50));
        //To add paddings inside the panel I used EmptyBorder along with Insets-> Reason: To make the buttons more centralised
        mainMenu.setBorder(new EmptyBorder(new Insets(220,220,220,220)));
        mainMenu.add(empButton);
        mainMenu.add(cliButton);
        mainMenu.add(proButton);

        cliMenu.setLayout(new GridLayout(3,0,0,50));
        cliMenu.setBorder(new EmptyBorder(new Insets(220,220,220,220)));
        cliMenu.add(addCliButton);
        cliMenu.add(removeCliButton);

        empMenu.setLayout(new GridLayout(3,0,0,50));
        empMenu.setBorder(new EmptyBorder(new Insets(220,220,220,220)));
        empMenu.add(addEmplButton);
        empMenu.add(removeEmpButton);


               
        //menuHeadingPanel.setBorder(new EmptyBorder(new Insets(50,50,50,50)));
        heading.setFont(new Font("Verdana", Font.PLAIN, 35)); //to set the font-style and font-size of a Label
        menuHeadingPanel.add(heading);
        
        //menuHeadingPanel.setBackground(Color.BLUE);
     
        cliButton.addActionListener(new manageClientListener());
        empButton.addActionListener(new manageEmployeeListener());
        addCliButton.addActionListener(new handleInputClient());
        addEmplButton.addActionListener(new handleInputEmployee());
        submit.addActionListener(new handleEmployeeData());

        frame.add(mainMenu,BorderLayout.CENTER);
        frame.add(menuHeadingPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* testing.add(addClient,BorderLayout.CENTER);
        testing.add(menuHeadingPanel,BorderLayout.NORTH);
        testing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
    }
    
    void addClientGUI(){
        addClient.setLayout(new GridLayout(10,2,10,50));
        addClient.setBorder(new EmptyBorder(new Insets(5,5,5,5)));

        addClient.add(name);
        addClient.add(nameTextField);
        addClient.add(streetName);
        addClient.add(streetNameTextField);
        addClient.add(locality);
        addClient.add(localityTextField);
        addClient.add(District);
        addClient.add(DistrictTextField);
        addClient.add(state);
        addClient.add(stateTextField);
        addClient.add(pincode);
        addClient.add(pincodeTextField);
        addClient.add(nationality);
        addClient.add(nationalityTextField);
        addClient.add(dob);
        addClient.add(dobTextField);
    }

    void addEmpGUI(){
        addEmp.setLayout(new GridLayout(12,2,10,50));
        addEmp.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
        
        addEmp.add(name);
        addEmp.add(nameTextField);
        addEmp.add(streetName);
        addEmp.add(streetNameTextField);
        addEmp.add(locality);
        addEmp.add(localityTextField);
        addEmp.add(District);
        addEmp.add(DistrictTextField);
        addEmp.add(state);
        addEmp.add(stateTextField);
        addEmp.add(pincode);
        addEmp.add(pincodeTextField);
        addEmp.add(nationality);
        addEmp.add(nationalityTextField);
        addEmp.add(dob);
        addEmp.add(dobTextField);
        addEmp.add(experience);
        addEmp.add(experienceTextField);
        addEmp.add(domain);
        //Reference for the domain: https://www.quora.com/What-are-the-different-domains-in-software-development
        String[] domainChoices = {"WEB","ANDROID","SCIENTIFIC","BUSINESS", "MEDICAL","INDUSTRIAL & PROCESS CONTROL","SYSTEMS SOFTWARE", "TOOL DEVELOPMENT(COMPILERS, ASSEMBLERS)"};
        domainComboBox = new JComboBox<String>(domainChoices);
        domainComboBox.setBackground(Color.WHITE);
        addEmp.add(domainComboBox);
    }

    
    class manageClientListener implements ActionListener{


        public void actionPerformed(ActionEvent a){
            frame.remove(mainMenu);
            heading.setText("Client Management Menu");
            frame.add(cliMenu,BorderLayout.CENTER);
        }
    }

    class manageEmployeeListener implements ActionListener{
        

        public void actionPerformed(ActionEvent a){
            frame.remove(mainMenu);
            heading.setText("Employee Management Menu");;
            frame.add(empMenu,BorderLayout.CENTER);
        }
    }

    class handleInputClient implements ActionListener{

        public void actionPerformed(ActionEvent a){
            frame.remove(cliMenu);
            heading.setText("Input Client Information");
            addClientGUI();
            frame.add(addClient,BorderLayout.CENTER);
            frame.add(submit,BorderLayout.SOUTH);
        }
    }

    class handleInputEmployee implements ActionListener{

        public void actionPerformed(ActionEvent a){
            frame.remove(empMenu);
            heading.setText("Input Employee Information");
            addEmpGUI();
            frame.add(addEmp,BorderLayout.CENTER);
            frame.add(submit,BorderLayout.SOUTH);
        }
    }

    class handleEmployeeData implements ActionListener{
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            employee em = new employee();
            em.setName(nameTextField.getText());
            String[] address = new String[4];
            address[0] = streetNameTextField.getText();
            address[1] = localityTextField.getText();
            address[2] = DistrictTextField.getText();
            address[3] = stateTextField.getText();
            em.setAddress(address);
            int failure = 1; //success -> 0, failure ->1
            int PINCODE = 0;
            try{
                PINCODE = Integer.parseInt(pincodeTextField.getText());
                em.setPINCODE(PINCODE);
                em.setNationality(nationalityTextField.getText());
                em.setDOB(dobTextField.getText());
                em.setExperience(Integer.parseInt(experienceTextField.getText()));
                em.setDomain(domainComboBox.getItemAt(domainComboBox.getSelectedIndex()));
                failure = ad.AddPerson(em);
            }catch(NumberFormatException nfe){
                System.out.println("PINCODE must contain only numbers");
                JOptionPane.showMessageDialog(frame, "PINCODE and Experience must contain only numbers", "WARNING", JOptionPane.WARNING_MESSAGE);
            }finally{
                System.out.println("Entered here");
                if(failure == 0){
                    JOptionPane.showMessageDialog(frame, "Data Entry Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new admingui();

                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    frame.dispose();
                    new admingui();
                }
            }
            
        }
    }

    class handleClientData implements ActionListener{
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            client em = new client();
            em.setName(nameTextField.getText());
            String[] address = new String[4];
            address[0] = streetNameTextField.getText();
            address[1] = localityTextField.getText();
            address[2] = DistrictTextField.getText();
            address[3] = stateTextField.getText();
            em.setAddress(address);
            int failure = 1; //success -> 0, failure ->1
            int PINCODE = 0;
            try{
                PINCODE = Integer.parseInt(pincodeTextField.getText());
                em.setPINCODE(PINCODE);
                em.setNationality(nationalityTextField.getText());
                em.setDOB(dobTextField.getText());
                failure = ad.AddPerson(em);
            }catch(NumberFormatException nfe){
                System.out.println("PINCODE must containt only numbers");
                JOptionPane.showMessageDialog(frame, "PINCODE must contain only numbers", "WARNING", JOptionPane.WARNING_MESSAGE);
            }finally{
                System.out.println("Entered here");
                if(failure == 0){
                    JOptionPane.showMessageDialog(frame, "Data Entry Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new admingui();
                    
                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    frame.dispose();
                    new admingui();
                }
            }
            
        }
    }
}




class Driver{
    public static void main(String[] args) {
        new admingui();
    }
}