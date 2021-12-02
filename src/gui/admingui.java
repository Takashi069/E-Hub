package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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
    JPanel remEmp = new JPanel();
    JPanel remClient = new JPanel();

    JLabel heading = new JLabel("Welcome Administrator");
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name: ");
    JLabel streetName = new JLabel("Street Address: ");
    JLabel locality = new JLabel("Locality: ");
    JLabel District = new JLabel("District: ");
    JLabel state = new JLabel("State: ");
    JLabel pincode = new JLabel("PINCODE: ");
    JLabel nationality = new JLabel("Nationality: ");
    JLabel dob = new JLabel("DOB ( Format: YYYY-MM-DD )");
    JLabel experience = new JLabel("Experience (In Years)");
    JLabel domain = new JLabel("Specialisation Domain");
    JLabel Company = new JLabel("Company");
    JLabel totalOrders = new JLabel("Total Orders");

    JLabel dynamicID = new JLabel();
    JLabel dynamicName = new JLabel();
    JLabel dynamicDOB = new JLabel();
    JLabel dynamicCompany = new JLabel();
    JLabel dynamicTotalOrder = new JLabel();
    JLabel dynamicDomain = new JLabel();
    JLabel dynamicExperience = new JLabel();

    
    JButton empButton = new JButton("Manage Employees");
    JButton cliButton = new JButton("Manage Clients");
    JButton proButton = new JButton("Manage Projects");
    JButton addCliButton = new JButton("Add New Clients");
    JButton addEmplButton = new JButton("Add New Employees");
    JButton submit1 = new JButton("Submit");
    JButton submit2 = new JButton("Submit");
    JButton remove1 = new JButton("Remove");
    JButton remove2 = new JButton("Remove");


    
    JButton removeCliButton = new JButton("Remove Clients");
    JButton removeEmpButton = new JButton("Remove Employee");

    JTextField idTextField = new JTextField();
    JTextField nameTextField = new JTextField("Sherlock Holmes");
    JTextField streetNameTextField = new JTextField("221B");
    JTextField localityTextField = new JTextField("Baker Street");
    JTextField DistrictTextField = new JTextField("Central London");
    JTextField stateTextField = new JTextField("London");
    JTextField pincodeTextField = new JTextField("125462");
    JTextField nationalityTextField = new JTextField("UK");
    JTextField dobTextField = new JTextField("1969-10-24");
    JTextField experienceTextField = new JTextField("12");
    JTextField companyTextField = new JTextField("Apple");
    
    String[] emptyArray = {"null"};
    //It is used to create a drop down menu of the various domains
    JComboBox<String> domainComboBox;
    JComboBox<String> allID = new JComboBox<String>(emptyArray);
    
    

    

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
        removeCliButton.addActionListener(new handleRemoveClient());
        removeEmpButton.addActionListener(new handleRemoveEmployee());
        submit1.addActionListener(new handleEmployeeData());
        submit2.addActionListener(new handleClientData());
        remove1.addActionListener(new handleRemovePerson("client"));
        remove2.addActionListener(new handleRemovePerson("employee"));

       

        frame.add(mainMenu,BorderLayout.CENTER);
        frame.add(menuHeadingPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* testing.add(addClient,BorderLayout.CENTER);
        testing.add(menuHeadingPanel,BorderLayout.NORTH);
        testing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
    }
    
    private void addClientGUI(){
        

        addClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;//column
        gbc.gridy = 0;//row   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20,20,20,0);    
        gbc.ipady = 10; // height of the grid 
        addClient.add(name,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 40;
        addClient.add(nameTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(streetName,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(streetNameTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(locality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(localityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(District,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(DistrictTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(state,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(stateTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(pincode,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(pincodeTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(nationality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(nationalityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(dob,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(dobTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(Company,gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(companyTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(submit2,gbc);
    }

    private void addEmpGUI(){
        addEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;//column
        gbc.gridy = 0;//row   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20,20,20,0);    
        gbc.ipady = 10; // height of the grid 
        addEmp.add(name,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nameTextField,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(streetName,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(streetNameTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(locality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(localityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(District,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(DistrictTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(state,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(stateTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(pincode,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(pincodeTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nationality,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nationalityTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(dob,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(dobTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(experience,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(experienceTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        addEmp.add(domain,gbc);
        //Reference for the domain: https://www.quora.com/What-are-the-different-domains-in-software-development
        String[] domainChoices = {"WEB","ANDROID","SCIENTIFIC","BUSINESS", "MEDICAL","INDUSTRIAL & PROCESS CONTROL","SYSTEMS SOFTWARE", "TOOL DEVELOPMENT(COMPILERS, ASSEMBLERS)"};
        domainComboBox = new JComboBox<String>(domainChoices);
        domainComboBox.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 9;
        addEmp.add(domainComboBox,gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(submit1,gbc);
    }

    private void remClientGUI(){
        admin ad = new admin();
        client cli = new client();
        String[] ID = ad.PersonList(cli);
        remClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID = new JComboBox<String>(ID);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20,20,20,0);    
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(id,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID.setBackground(Color.white);
        remClient.add(allID,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(name,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dob,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicDOB,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(Company,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicCompany,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(totalOrders,gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicTotalOrder,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(remove1,gbc);
        allID.addActionListener(new handleShowDetails("client"));
    }

    private void updateRemGUI(client C){
        dynamicName.setText(C.getName());
        dynamicDOB.setText(C.getDOB());
        dynamicCompany.setText(C.getCompany());
        dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }

    private void updateRemGUI( employee E){
        dynamicName.setText(E.getName());
        dynamicDOB.setText(E.getDOB());
        dynamicExperience.setText(String.format("%d", E.getExperience()));
        dynamicDomain.setText(E.getDomain());
    }

    private void remEmpGUI(){
        admin ad = new admin();
        employee emp = new employee();
        remEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] ID = ad.PersonList(emp);
        allID = new JComboBox<String>(ID);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20,20,20,0);    
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(id,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID.setBackground(Color.white);
        remEmp.add(allID,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(name,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dob,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDOB,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(experience,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicExperience,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(domain,gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDomain,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(remove2,gbc);
        System.out.println("Checking");
        allID.addActionListener(new handleShowDetails("employee"));
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
            //frame.add(submit,BorderLayout.SOUTH);
        }
    }

    class handleInputEmployee implements ActionListener{

        public void actionPerformed(ActionEvent a){
            frame.remove(empMenu);
            heading.setText("Input Employee Information");
            addEmpGUI();
            frame.add(addEmp,BorderLayout.CENTER);
            //frame.add(submit,BorderLayout.SOUTH);
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
            client cli = new client();
            cli.setName(nameTextField.getText());
            String[] address = new String[4];
            address[0] = streetNameTextField.getText();
            address[1] = localityTextField.getText();
            address[2] = DistrictTextField.getText();
            address[3] = stateTextField.getText();
            cli.setAddress(address);
            cli.setCompany(companyTextField.getText());
            int failure = 1; //success -> 0, failure ->1
            int PINCODE = 0;
            try{
                PINCODE = Integer.parseInt(pincodeTextField.getText());
                cli.setPINCODE(PINCODE);
                cli.setNationality(nationalityTextField.getText());
                cli.setDOB(dobTextField.getText());
                failure = ad.AddPerson(cli);
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

    class handleRemoveEmployee implements ActionListener{
        public void actionPerformed(ActionEvent a){
            frame.remove(empMenu);
            heading.setText("Remove Employee");
            remEmpGUI();
            frame.add(remEmp,BorderLayout.CENTER);
        }
    }

    class handleRemoveClient implements ActionListener{
        public void actionPerformed(ActionEvent a){
            frame.remove(cliMenu);
            heading.setText("Remove Client");
            remClientGUI();
            frame.add(remClient,BorderLayout.CENTER);
        }
    }
    
    class handleRemovePerson implements ActionListener{
        private String type;
        
        handleRemovePerson(){
            type = "null";
        }
        handleRemovePerson(String type){
            this.type = type;
        }

        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            int input = JOptionPane.showConfirmDialog(frame, "Confirm Deletion of Person", "WARNING", JOptionPane.YES_NO_OPTION);
            //0->Yes, 1->No
            if(type.compareToIgnoreCase("client") == 0 && input == 0){
                client cli = new client();
                cli.setID((String)allID.getSelectedItem());
                ad.removePerson(cli);
                JOptionPane.showMessageDialog(frame, "Data Deleted", "Info", JOptionPane.PLAIN_MESSAGE);
            }else if(type.compareToIgnoreCase("employee") == 0 && input == 0){
                employee emp = new employee();
                emp.setID((String)allID.getSelectedItem());
                ad.removePerson(emp);
                JOptionPane.showMessageDialog(frame, "Data Deleted", "Info", JOptionPane.PLAIN_MESSAGE);
            }
            if(input == 0){
                frame.dispose();
                new admingui();
            }
        }

    }

    class handleShowDetails implements ActionListener{
        private String type;
        handleShowDetails(){
            type = "NULL";
        }
        handleShowDetails(String type){
            this.type = type;
        }
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            if(type.compareToIgnoreCase("client") == 0){
                client cli = new client();
                cli.setID((String)allID.getSelectedItem());
                cli = ad.showPrimaryDetails(cli);
                updateRemGUI(cli);
            }else if(type.compareToIgnoreCase("employee") == 0){
                employee emp = new employee();
                emp.setID((String)allID.getSelectedItem());
                emp = ad.showPrimaryDetails(emp);
                updateRemGUI(emp);
            }
        
        }
    }
}




class Driver{
    public static void main(String[] args) {
        new admingui();
    }
}