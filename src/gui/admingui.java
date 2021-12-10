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
    
    JPanel display = new JPanel();
    JPanel mainMenu = new JPanel();
    JPanel menuHeadingPanel = new JPanel();
    JPanel cliMenu = new JPanel();
    JPanel empMenu = new JPanel();
    JPanel addClient = new JPanel();
    JPanel addEmp = new JPanel();
    JPanel remEmp = new JPanel();
    JPanel remClient = new JPanel();
    JPanel project = new JPanel();

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
    JButton projectButton = new JButton("Manage Projects");
    JButton addCliButton = new JButton("Add New Clients");
    JButton addEmplButton = new JButton("Add New Employees");
    JButton viewNonApprovedProjects = new JButton("View Non-Approved Projects");
    JButton changeProjectStatus = new JButton("Change Project Status");
    JButton submit1 = new JButton("Submit");
    JButton submit2 = new JButton("Submit");
    JButton remove1 = new JButton("Remove");
    JButton remove2 = new JButton("Remove");
    JButton backButton = new JButton("Back");

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
    //Reference for the domain: https://www.quora.com/What-are-the-different-domains-in-software-development
    String[] domainChoices = {"WEB","ANDROID","SCIENTIFIC","BUSINESS", "MEDICAL","INDUSTRIAL & PROCESS CONTROL","SYSTEMS SOFTWARE", "TOOL DEVELOPMENT(COMPILERS, ASSEMBLERS)"};
        //It is used to create a drop down menu of the various domains
    JComboBox<String> domainComboBox = new JComboBox<String>(domainChoices);
    JComboBox<String> allID1 = new JComboBox<String>(emptyArray); //for Employee
    JComboBox<String> allID2 = new JComboBox<String>(emptyArray); //for Client 

    /*
        The reason why they were made two seperate comboBoxes were beecause, while using one, the other would also get called which caused wrong data to 
        be displayed
    */
    
    CardLayout card;

    

    //frame has BORDERLAYOUT by default
    public admingui(){
        card = new CardLayout();
        display.setLayout(card);
        frame.setSize(960,640);
        frame.setVisible(true);
        /*
         * testing.setSize(1280,1024);
         * testing.setVisible(true);
         */

        // GridLayout(rows, columns, horizontal gap, vertical gap)
        mainMenu.setLayout(new GridLayout(3, 0, 0, 50));
        // To add paddings inside the panel I used EmptyBorder along with Insets->
        // Reason: To make the buttons more centralised
        mainMenu.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
        mainMenu.add(empButton);
        mainMenu.add(cliButton);
        mainMenu.add(projectButton);


        //menuHeadingPanel.setBorder(new EmptyBorder(new Insets(50,50,50,50)));
        heading.setFont(new Font("Verdana", Font.PLAIN, 35)); //to set the font-style and font-size of a Label
        menuHeadingPanel.add(heading);
        
        //menuHeadingPanel.setBackground(Color.BLUE);
     
        cliButton.addActionListener(new manageClientListener());
        empButton.addActionListener(new manageEmployeeListener());
        projectButton.addActionListener(new manageProjectListener());
        addCliButton.addActionListener(new handleInputClient());
        addEmplButton.addActionListener(new handleInputEmployee());
        removeCliButton.addActionListener(new handleRemoveClient());
        removeEmpButton.addActionListener(new handleRemoveEmployee());
        submit1.addActionListener(new handleEmployeeData());
        submit2.addActionListener(new handleClientData());
        remove1.addActionListener(new handleRemovePerson("client"));
        remove2.addActionListener(new handleRemovePerson("employee"));

       

        display.add(mainMenu,"mainMenu");
        display.add(cliMenu,"clientMenu");
        display.add(empMenu,"employeeMenu");
        display.add(addClient,"addClientMenu");
        display.add(addEmp,"addEmployeeMenu");
        display.add(remEmp,"removeEmployeeMenu");
        display.add(remClient,"removeClientMenu");
        display.add(project,"projectMenu");


        frame.add(display,BorderLayout.CENTER);
        frame.add(menuHeadingPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * testing.add(addClient,BorderLayout.CENTER);
         * testing.add(menuHeadingPanel,BorderLayout.NORTH);
         * testing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         */
    }
    
    private void clientMenuGUI(){
        cliMenu.setLayout(new GridLayout(3,0,0,50));
        cliMenu.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
        cliMenu.add(addCliButton);
        cliMenu.add(removeCliButton);
        cliMenu.add(backButton);

    }

    private void empMenuGUI(){
        empMenu.setLayout(new GridLayout(3,0,0,50));
        empMenu.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
        empMenu.add(addEmplButton);
        empMenu.add(removeEmpButton);
        empMenu.add(backButton);
    }

    private void projectMenuGUI(){
        project.setLayout(new GridLayout(3,0,20,20));
        project.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
        project.add(viewNonApprovedProjects);
        project.add(changeProjectStatus);
        project.add(backButton);
        backButton.addActionListener(new goToMainMenu());
    }
        
    private void addClientGUI() {

        addClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;// column
        gbc.gridy = 0;// row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10; // height of the grid
        addClient.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 40;
        addClient.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(streetName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(streetNameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(locality, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(localityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(District, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(DistrictTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(state, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(stateTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(pincode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(pincodeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(nationality, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(nationalityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(dobTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(Company, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(companyTextField, gbc);
        //                      t,  l,  b,  r
        gbc.insets = new Insets(20, 0, 0, 20);
        gbc.gridx = 0;
        gbc.gridy = 9;
        addClient.add(backButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addClient.add(submit2, gbc);
    }

    private void addEmpGUI(){

        addEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;// column
        gbc.gridy = 0;// row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10; // height of the grid
        addEmp.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(streetName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(streetNameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(locality, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(localityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(District, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(DistrictTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(state, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(stateTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(pincode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(pincodeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nationality, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(nationalityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(dobTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(experience, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(experienceTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        addEmp.add(domain,gbc);
        
        domainComboBox.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 9;
        addEmp.add(domainComboBox, gbc);

        gbc.insets = new Insets(40, 0, 20, 10);
        gbc.gridx = 0;
        gbc.gridy = 10;
        addEmp.add(backButton,gbc);

        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addEmp.add(submit1, gbc);
    }

    private void remClientGUI() {
        admin ad = new admin();
        client cli = new client();
        String[] ID = ad.PersonList(cli);
        remClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID2.removeAllItems();
        for (String id : ID) {
            allID2.addItem(id);
        }
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

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicDOB, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(Company, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicCompany, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(totalOrders, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicTotalOrder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        remClient.add(backButton,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(remove1,gbc);
        allID2.addActionListener(new handleShowCliDetails());

    }

    private void updateRemGUI(client C) {
        dynamicName.setText(C.getName());
        dynamicDOB.setText(C.getDOB());
        dynamicCompany.setText(C.getCompany());
        //System.out.println("UpdateRemCliGUI: " + C.getName());
        dynamicTotalOrder.setText((String.format("%d", C.getTotal_Orders())));
    }

    private void updateRemGUI(employee E) {
        dynamicName.setText(E.getName());
        dynamicDOB.setText(E.getDOB());
        //System.out.println("UpdateRemEmpGUI: " + E.getName());
        dynamicExperience.setText(String.format("%d", E.getExperience()));
        dynamicDomain.setText(E.getDomain());
    }

    private void remEmpGUI() {
        admin ad = new admin();
        employee emp = new employee();
        remEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] ID = ad.PersonList(emp);
        allID1.removeAllItems();
        
        for (String id : ID) {
            allID1.addItem(id);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID1.setBackground(Color.white);
        remEmp.add(allID1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDOB, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(experience, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicExperience, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(domain, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDomain, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        remEmp.add(backButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(remove2,gbc);
        
        allID1.addActionListener(new handleShowEmpDetails());

    }
    
    //Event Handlers from this point 
    

    class manageClientListener implements ActionListener {

        public void actionPerformed(ActionEvent a){
            clientMenuGUI();
            card.show(display, "clientMenu");
            heading.setText("Client Management Menu");
            backButton.addActionListener(new goToMainMenu());
        }
    }

    class manageEmployeeListener implements ActionListener {

        public void actionPerformed(ActionEvent a){
            empMenuGUI();
            card.show(display,"employeeMenu");
            heading.setText("Employee Management Menu");
            backButton.addActionListener(new goToMainMenu());
        }
    }

    class manageProjectListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Projects Menu");
            projectMenuGUI();
            card.show(display,"projectMenu");
        }
    }
    class goToMainMenu implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Administrator Panel");
            card.show(display,"mainMenu");
        }
    }
    
    class handleInputClient implements ActionListener{

        public void actionPerformed(ActionEvent a){
            heading.setText("Input Client Information");
            addClientGUI();
            card.show(display,"addClientMenu");
            backButton.addActionListener(new manageClientListener());
            //frame.add(submit,BorderLayout.SOUTH);
        }
    }

    class handleInputEmployee implements ActionListener {

        public void actionPerformed(ActionEvent a){
            heading.setText("Input Employee Information");
            addEmpGUI();
            card.show(display,"addEmployeeMenu");
            backButton.addActionListener(new manageEmployeeListener());
            //frame.add(submit,BorderLayout.SOUTH);
        }
    }

    class handleEmployeeData implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            admin ad = new admin();
            employee em = new employee();
            em.setName(nameTextField.getText());
            String[] address = new String[4];
            address[0] = streetNameTextField.getText();
            address[1] = localityTextField.getText();
            address[2] = DistrictTextField.getText();
            address[3] = stateTextField.getText();
            em.setAddress(address);
            int failure = 1; // success -> 0, failure ->1
            int PINCODE = 0;
            try {
                PINCODE = Integer.parseInt(pincodeTextField.getText());
                em.setPINCODE(PINCODE);
                em.setNationality(nationalityTextField.getText());
                em.setDOB(dobTextField.getText());
                em.setExperience(Integer.parseInt(experienceTextField.getText()));
                em.setDomain(domainComboBox.getItemAt(domainComboBox.getSelectedIndex()));
                failure = ad.AddPerson(em);
            } catch (NumberFormatException nfe) {
                System.out.println("PINCODE must contain only numbers");
                JOptionPane.showMessageDialog(frame, "PINCODE and Experience must contain only numbers", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
            } finally {
                System.out.println("Entered here");
                if(failure == 0){
                    JOptionPane.showMessageDialog(frame, "Data Entry Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
                    card.show(display, "mainMenu");


                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    card.show(display, "mainMenu");
                }
            }

        }
    }

    class handleClientData implements ActionListener {
        public void actionPerformed(ActionEvent a) {
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
            int failure = 1; // success -> 0, failure ->1
            int PINCODE = 0;
            try {
                PINCODE = Integer.parseInt(pincodeTextField.getText());
                cli.setPINCODE(PINCODE);
                cli.setNationality(nationalityTextField.getText());
                cli.setDOB(dobTextField.getText());
                failure = ad.AddPerson(cli);
            } catch (NumberFormatException nfe) {
                System.out.println("PINCODE must containt only numbers");
                JOptionPane.showMessageDialog(frame, "PINCODE must contain only numbers", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
            } finally {
                //System.out.println("Entered here");
                if(failure == 0){
                    JOptionPane.showMessageDialog(frame, "Data Entry Successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
                    card.show(display,"mainMenu");
                    
                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    card.show(display,"mainMenu");
                }
            }

        }
    }

    class handleRemoveEmployee implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Remove Employee");
            remEmpGUI();
            card.show(display,"removeEmployeeMenu");
        }
    }

    class handleRemoveClient implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Remove Client");
            remClientGUI();
            card.show(display,"removeClientMenu");
        }
    }

    class handleRemovePerson implements ActionListener {
        private String type;

        handleRemovePerson() {
            type = "null";
        }

        handleRemovePerson(String type) {
            this.type = type;
        }

        public void actionPerformed(ActionEvent a) {
            admin ad = new admin();
            int input = JOptionPane.showConfirmDialog(frame, "Confirm Deletion of Person", "WARNING",
                    JOptionPane.YES_NO_OPTION);
            // 0->Yes, 1->No
            if (type.compareToIgnoreCase("client") == 0 && input == 0) {
                client cli = new client();
                cli.setID((String) allID2.getSelectedItem());
                ad.removePerson(cli);
                JOptionPane.showMessageDialog(frame, "Data Deleted", "Info", JOptionPane.PLAIN_MESSAGE);
            } else if (type.compareToIgnoreCase("employee") == 0 && input == 0) {
                employee emp = new employee();
                emp.setID((String) allID1.getSelectedItem());
                ad.removePerson(emp);
                JOptionPane.showMessageDialog(frame, "Data Deleted", "Info", JOptionPane.PLAIN_MESSAGE);
            }
            if(input == 0){
                heading.setText("Administrator Menu");
                card.show(display,"mainMenu");
            }else if(type.compareToIgnoreCase("employee") == 0){
                card.show(display,"removeEmployeeMenu");
            }else if(type.compareToIgnoreCase("client") == 0){//the else is to prevent the duplication of the ID's when the user clicks on No in the Pop-Up Dialog box
                card.show(display,"removeClientMenu");
            }
        }

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

    class handleShowEmpDetails implements ActionListener{
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            employee emp = new employee();
            emp.setID((String) allID1.getSelectedItem());
            emp = ad.showPrimaryDetails(emp);
            //System.out.println("\nEmployee GUI Details called\n");
            updateRemGUI(emp);
        }
    }
}

class Driver {
    public static void main(String[] args) {
        new admingui();
    }
}