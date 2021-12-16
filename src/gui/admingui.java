package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import assets.getAssets;
import employee.employee;
import exceptions.noData;
import exceptions.noEmployeeAvailable;
import client.client;
import Project.project;


public class admingui{
    
    JFrame frame = new JFrame("Admin Menu");
    getAssets path = new getAssets();
    JPanel display = new JPanel();
    JLabel mainMenu = new JLabel(new ImageIcon(path.frame_bg));
    JPanel menuHeadingPanel = new JPanel();
    JLabel cliMenu = new JLabel(new ImageIcon(path.frame_bg));
    JLabel empMenu = new JLabel(new ImageIcon(path.frame_bg));
    JLabel addClient = new JLabel(new ImageIcon(path.frame_bg));
    JLabel addEmp = new JLabel(new ImageIcon(path.frame_bg));
    JLabel remEmp = new JLabel(new ImageIcon(path.frame_bg));
    JLabel remClient = new JLabel(new ImageIcon(path.frame_bg));
    JLabel project = new JLabel(new ImageIcon(path.frame_bg));
    JLabel projectApprove = new JLabel(new ImageIcon(path.frame_bg));
    JLabel projectUpdateStatus = new JLabel(new ImageIcon(path.frame_bg));

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
    JLabel projectName = new JLabel("Project Name");
    JLabel clientID = new JLabel("Client ID");
    JLabel status = new JLabel("Status of Software: ");
    JLabel deadline = new JLabel("Deadline Date(YYYY-MM-DD)");
    JLabel projectsWorked = new JLabel("Total Projects Worked");
    JLabel projectsLed = new JLabel("Total Projects Led");
    JLabel descriptionLabel = new JLabel("Project Description");
    JLabel priorityLabel = new JLabel("Priority");


    JTextField dynamicID = new JTextField();
    JTextField dynamicName = new JTextField();
    JTextField dynamicDOB = new JTextField();
    JTextField dynamicCompany = new JTextField();
    JTextField dynamicTotalOrder = new JTextField();
    JTextField dynamicDomain = new JTextField();
    JTextField dynamicExperience = new JTextField();
    JTextField dynamicProjectsWorked = new JTextField();
    JTextField dynamicProjectsLed = new JTextField();
    JTextField dynamicProjectNameTextField = new JTextField();
    JTextField dynamicClientIDTextField = new JTextField();
    JTextField dynamicStatusTextField = new JTextField();
    JTextField dynamicDeadlineTextField = new JTextField();
    JTextField dynamicPriority = new JTextField();

    JButton empButton = new JButton(new ImageIcon(path.manage_emp));
    JButton cliButton = new JButton(new ImageIcon(path.manage_client));
    JButton projectButton = new JButton(new ImageIcon(path.manage_projects));
    JButton addCliButton = new JButton(new ImageIcon(path.add_client));
    JButton addEmplButton = new JButton(new ImageIcon(path.add_emp));
    JButton viewClientReport = new JButton(new ImageIcon(path.stats_client));
    JButton viewNonApprovedProjects = new JButton(new ImageIcon(path.pending_changes));
    JButton changeProjectStatus = new JButton(new ImageIcon(path.change_status));
    JButton viewProjects = new JButton(new ImageIcon(path.view_bg));
    JButton submit1 = new JButton(new ImageIcon(path.submit_button));
    JButton submit2 = new JButton(new ImageIcon(path.submit_button));
    JButton change1 = new JButton(new ImageIcon(path.change_button));
    JButton Approve = new JButton(new ImageIcon(path.approve_button));
    JButton reject = new JButton(new ImageIcon(path.reject_button));
    JButton remove1 = new JButton(new ImageIcon(path.remove_button));
    JButton remove2 = new JButton(new ImageIcon(path.remove_button));
    JButton backButton = new JButton(new ImageIcon(path.back_arrow_btn));
    JButton backSmallButton = new JButton(new ImageIcon(path.back_btn));
    JButton viewChanges = new JButton(new ImageIcon(path.project_change_requested));
    JButton logout = new JButton(new ImageIcon(path.logout_button));

    JButton removeCliButton = new JButton(new ImageIcon(path.remove_client));
    JButton removeEmpButton = new JButton(new ImageIcon(path.remove_emp));

    JButton viewEmpButton = new JButton(new ImageIcon(path.stats_emp));

    JTextField idTextField = new JTextField();
    JTextField nameTextField = new JTextField("TestName");
    JTextField streetNameTextField = new JTextField("TestStreetName");
    JTextField localityTextField = new JTextField("TestLocality");
    JTextField DistrictTextField = new JTextField("TestDistrict");
    JTextField stateTextField = new JTextField("TestState");
    JTextField pincodeTextField = new JTextField("123456");
    JTextField nationalityTextField = new JTextField("TestNationality");
    JTextField dobTextField = new JTextField("2001-07-08");
    JTextField experienceTextField = new JTextField("12");
    JTextField companyTextField = new JTextField("TestCompany");
    JTextArea descriptionTextField = new JTextArea(10, 50);
    JScrollPane scroll = new JScrollPane(descriptionTextField,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    
    String[] emptyArray = {"null"};
    //Reference for the domain: https://www.quora.com/What-are-the-different-domains-in-software-development
    final String[] domainChoices = {"WEB","ANDROID","SCIENTIFIC","BUSINESS", "MEDICAL","INDUSTRIAL & PROCESS CONTROL","SYSTEMS SOFTWARE", "TOOL DEVELOPMENT"};
    final String[] statusChoices = {"APPROVED","REJECTED","DEADLINE DATE CHANGED","CHANGES REJECTED","CHANGES APPROVED","WORK IN PROGRESS","TESTING","COMPLETED","PAID"};
    //It is used to create a drop down menu of the various domains
    JComboBox<String> domainComboBox = new JComboBox<String>(domainChoices);
    JComboBox<String> allID1 = new JComboBox<String>(emptyArray); //for Employee
    JComboBox<String> allID2 = new JComboBox<String>(emptyArray); //for Client 
    JComboBox<String> allID3 = new JComboBox<String>(emptyArray); //for project
    JComboBox<String> statusComboBox = new JComboBox<String>(statusChoices); //for Project Status 
    /*
        The reason why they were made two seperate comboBoxes were beecause, while using one, the other would also get called which caused wrong data to 
        be displayed
    */
    
    CardLayout card;

    public void setTheme(){
        empButton.setFocusPainted(false);
        id.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        streetName.setForeground(Color.WHITE);
        locality.setForeground(Color.WHITE);
        District.setForeground(Color.WHITE);
        state.setForeground(Color.WHITE);
        pincode.setForeground(Color.WHITE);
        nationality.setForeground(Color.WHITE);
        dob.setForeground(Color.WHITE);
        experience.setForeground(Color.WHITE);
        domain.setForeground(Color.WHITE);
        Company.setForeground(Color.WHITE);
        totalOrders.setForeground(Color.WHITE);
        projectName.setForeground(Color.WHITE);
        clientID.setForeground(Color.WHITE);
        status.setForeground(Color.WHITE);
        deadline.setForeground(Color.WHITE);
        projectsWorked.setForeground(Color.WHITE);
        projectsLed.setForeground(Color.WHITE);

        dynamicID.setForeground(Color.WHITE);
        dynamicID.setBackground(Color.DARK_GRAY);
        dynamicID.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicID.setCaretColor(Color.WHITE);

        dynamicName.setForeground(Color.WHITE);
        dynamicName.setBackground(Color.DARK_GRAY);
        dynamicName.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicName.setCaretColor(Color.WHITE);

        dynamicDOB.setForeground(Color.WHITE);
        dynamicDOB.setBackground(Color.DARK_GRAY);
        dynamicDOB.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicDOB.setCaretColor(Color.WHITE);

        dynamicCompany.setForeground(Color.WHITE);
        dynamicCompany.setBackground(Color.DARK_GRAY);
        dynamicCompany.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicCompany.setCaretColor(Color.WHITE);

        dynamicTotalOrder.setForeground(Color.WHITE);
        dynamicTotalOrder.setBackground(Color.DARK_GRAY);
        dynamicTotalOrder.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicTotalOrder.setCaretColor(Color.WHITE);

        dynamicDomain.setForeground(Color.WHITE);
        dynamicDomain.setBackground(Color.DARK_GRAY);
        dynamicDomain.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicDomain.setCaretColor(Color.WHITE);

        dynamicExperience.setForeground(Color.WHITE);
        dynamicExperience.setBackground(Color.DARK_GRAY);
        dynamicExperience.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicExperience.setCaretColor(Color.WHITE);

        dynamicProjectsWorked.setForeground(Color.WHITE);
        dynamicProjectsWorked.setBackground(Color.DARK_GRAY);
        dynamicProjectsWorked.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicProjectsWorked.setCaretColor(Color.WHITE);

        dynamicProjectsLed.setForeground(Color.WHITE);
        dynamicProjectsLed.setBackground(Color.DARK_GRAY);
        dynamicProjectsLed.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicProjectsLed.setCaretColor(Color.WHITE);


        dynamicProjectNameTextField.setForeground(Color.WHITE);
        dynamicProjectNameTextField.setBackground(Color.DARK_GRAY);
        dynamicProjectNameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicProjectNameTextField.setCaretColor(Color.WHITE);

        dynamicClientIDTextField.setForeground(Color.WHITE);
        dynamicClientIDTextField.setBackground(Color.DARK_GRAY);
        dynamicClientIDTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicClientIDTextField.setCaretColor(Color.WHITE);

        dynamicStatusTextField.setForeground(Color.WHITE);
        dynamicStatusTextField.setBackground(Color.DARK_GRAY);
        dynamicStatusTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicStatusTextField.setCaretColor(Color.WHITE);

        dynamicDeadlineTextField.setForeground(Color.WHITE);
        dynamicDeadlineTextField.setBackground(Color.DARK_GRAY);
        dynamicDeadlineTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicDeadlineTextField.setCaretColor(Color.WHITE);

        dynamicPriority.setForeground(Color.WHITE);
        dynamicPriority.setBackground(Color.DARK_GRAY);
        dynamicPriority.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicPriority.setCaretColor(Color.WHITE);

        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);

        idTextField.setForeground(Color.WHITE);
        idTextField.setBackground(Color.DARK_GRAY);
        idTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        idTextField.setCaretColor(Color.WHITE);

        nameTextField.setForeground(Color.WHITE);
        nameTextField.setBackground(Color.DARK_GRAY);
        nameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        nameTextField.setCaretColor(Color.WHITE);

        streetNameTextField.setForeground(Color.WHITE);
        streetNameTextField.setBackground(Color.DARK_GRAY);
        streetNameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        streetNameTextField.setCaretColor(Color.WHITE);

        localityTextField.setForeground(Color.WHITE);
        localityTextField.setBackground(Color.DARK_GRAY);
        localityTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        localityTextField.setCaretColor(Color.WHITE);

        DistrictTextField.setForeground(Color.WHITE);
        DistrictTextField.setBackground(Color.DARK_GRAY);
        DistrictTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        DistrictTextField.setCaretColor(Color.WHITE);

        stateTextField.setForeground(Color.WHITE);
        stateTextField.setBackground(Color.DARK_GRAY);
        stateTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        stateTextField.setCaretColor(Color.WHITE);

        pincodeTextField.setForeground(Color.WHITE);
        pincodeTextField.setBackground(Color.DARK_GRAY);
        pincodeTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        pincodeTextField.setCaretColor(Color.WHITE);

        nationalityTextField.setForeground(Color.WHITE);
        nationalityTextField.setBackground(Color.DARK_GRAY);
        nationalityTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        nationalityTextField.setCaretColor(Color.WHITE);

        dobTextField.setForeground(Color.WHITE);
        dobTextField.setBackground(Color.DARK_GRAY);
        dobTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        dobTextField.setCaretColor(Color.WHITE);

        experienceTextField.setForeground(Color.WHITE);
        experienceTextField.setBackground(Color.DARK_GRAY);
        experienceTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        experienceTextField.setCaretColor(Color.WHITE);
        
        companyTextField.setForeground(Color.WHITE);
        companyTextField.setBackground(Color.DARK_GRAY);
        companyTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        companyTextField.setCaretColor(Color.WHITE);

        domainComboBox.setForeground(Color.WHITE);
        domainComboBox.setBackground(Color.DARK_GRAY);
        domainComboBox.setBorder(new LineBorder(Color.DARK_GRAY));
        
        allID1.setForeground(Color.WHITE);
        allID1.setBackground(Color.DARK_GRAY);
        allID1.setBorder(new LineBorder(Color.DARK_GRAY));

        allID2.setForeground(Color.WHITE);
        allID2.setBackground(Color.DARK_GRAY);
        allID2.setBorder(new LineBorder(Color.DARK_GRAY));

        allID3.setForeground(Color.WHITE);
        allID3.setBackground(Color.DARK_GRAY);
        allID3.setBorder(new LineBorder(Color.DARK_GRAY));

        statusComboBox.setForeground(Color.WHITE);
        statusComboBox.setBackground(Color.DARK_GRAY);
        statusComboBox.setBorder(new LineBorder(Color.DARK_GRAY));
    }

    //frame has BORDERLAYOUT by default
    public admingui(){
        setTheme();
        card = new CardLayout();
        display.setLayout(card);
        frame.setSize(1280, 1024);
        
        /*
         * testing.setSize(1280,1024);
         * testing.setVisible(true);
         */
        // GridLayout(rows, columns, horizontal gap, vertical gap)
        mainMenu.setLayout(new GridLayout(2, 2, 0, 50));
        // To add paddings inside the panel I used EmptyBorder along with Insets->
        // Reason: To make the buttons more centralised
        mainMenu.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

    
        cliButton.setOpaque(false);
        cliButton.setContentAreaFilled(false);
        cliButton.setBorderPainted(false);
        
        empButton.setOpaque(false);
        empButton.setContentAreaFilled(false);
        empButton.setBorderPainted(false);

        projectButton.setOpaque(false);
        projectButton.setContentAreaFilled(false);
        projectButton.setBorderPainted(false);

        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);

        mainMenu.add(empButton);
        mainMenu.add(cliButton);
        mainMenu.add(projectButton);
        mainMenu.add(logout);


        //menuHeadingPanel.setBorder(new EmptyBorder(new Insets(50,50,50,50)));
        heading.setFont(new Font("Verdana", Font.PLAIN, 35)); //to set the font-style and font-size of a Label
        
        //menuHeadingPanel.setBackground(Color.BLUE);
     
        cliButton.addActionListener(new manageClientListener());
        empButton.addActionListener(new manageEmployeeListener());
        projectButton.addActionListener(new manageProjectListener());
        addCliButton.addActionListener(new handleInputClient());
        addEmplButton.addActionListener(new handleInputEmployee());
        removeCliButton.addActionListener(new handleRemoveClient());
        removeEmpButton.addActionListener(new handleRemoveEmployee());
        viewEmpButton.addActionListener(new handleViewEmployee());
        submit1.addActionListener(new handleEmployeeData());
        submit2.addActionListener(new handleClientData());
        remove1.addActionListener(new handleRemovePerson("client"));
        remove2.addActionListener(new handleRemovePerson("employee"));
        backSmallButton.addActionListener(new goToMainMenu()); //since the backSmallButton is always listening to the goToMainMenu
        viewClientReport.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                frame.dispose();
                new ClientReportGui();
            }
        });
        viewChanges.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                try{
                    new gui.admincomponents.projectInfo();
                    frame.dispose();
                }catch(noData nd){
                    nd.displaYError(frame);
                }
                }
        });
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                frame.dispose();
                login frame = new login();
                frame.setSize(new Dimension(1280, 1024));
                frame.setTitle("Login Form");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
       

        display.add(mainMenu,"mainMenu");
        display.add(cliMenu,"clientMenu");
        display.add(empMenu,"employeeMenu");
        display.add(addClient,"addClientMenu");
        display.add(addEmp,"addEmployeeMenu");
        display.add(remEmp,"removeEmployeeMenu");
        display.add(remClient,"removeClientMenu");
        display.add(project,"projectMenu");
        display.add(projectApprove,"projectApproveMenu");
        display.add(projectUpdateStatus,"projectStatusMenu");


        frame.add(display,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * testing.add(addClient,BorderLayout.CENTER);
         * testing.add(menuHeadingPanel,BorderLayout.NORTH);
         * testing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         */
        frame.setVisible(true);
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

    //no Problem with the Backbutton in ClientMenuGUI
    private void clientMenuGUI(){
        cliMenu.setLayout(new GridLayout(2,2,0,50));
        cliMenu.setBorder(new EmptyBorder(new Insets(50,50,50,50)));

        addCliButton.setOpaque(false);
        addCliButton.setContentAreaFilled(false);
        addCliButton.setBorderPainted(false);

        cliMenu.add(addCliButton);

        removeCliButton.setOpaque(false);
        removeCliButton.setContentAreaFilled(false);
        removeCliButton.setBorderPainted(false);

        cliMenu.add(removeCliButton);

        viewClientReport.setOpaque(false);
        viewClientReport.setContentAreaFilled(false);
        viewClientReport.setBorderPainted(false);

        cliMenu.add(viewClientReport);

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        cliMenu.add(backButton);
    }

    //no Problem with the Backbutton in empMenuGUI
    private void empMenuGUI(){
        empMenu.setLayout(new GridLayout(2,2,0,50));
        empMenu.setBorder(new EmptyBorder(new Insets(50,50,50,50)));

        addEmplButton.setOpaque(false);
        addEmplButton.setContentAreaFilled(false);
        addEmplButton.setBorderPainted(false);

        removeEmpButton.setOpaque(false);
        removeEmpButton.setContentAreaFilled(false);
        removeEmpButton.setBorderPainted(false);

        viewEmpButton.setOpaque(false);
        viewEmpButton.setContentAreaFilled(false);
        viewEmpButton.setBorderPainted(false);

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        empMenu.add(addEmplButton);
        empMenu.add(removeEmpButton);
        empMenu.add(viewEmpButton);
        empMenu.add(backButton);
        
    }

    //commented out backSmallButton in projectMenuGUI
    private void projectMenuGUI(){
        project.setLayout(new GridLayout(2,2,0,50));
        project.setBorder(new EmptyBorder(new Insets(50,50,50,50)));

        viewNonApprovedProjects.setOpaque(false);
        viewNonApprovedProjects.setContentAreaFilled(false);
        viewNonApprovedProjects.setBorderPainted(false);

        changeProjectStatus.setOpaque(false);
        changeProjectStatus.setContentAreaFilled(false);
        changeProjectStatus.setBorderPainted(false);

        viewProjects.setOpaque(false);
        viewProjects.setContentAreaFilled(false);
        viewProjects.setBorderPainted(false);

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        project.add(viewNonApprovedProjects);
        project.add(changeProjectStatus);
        project.add(viewProjects);
        project.add(backButton);

        changeProjectStatus.addActionListener(new goToChangeStatus());
        viewNonApprovedProjects.addActionListener(new handleApproveProjects());
        viewProjects.addActionListener(new handleViewProjects());
        backButton.addActionListener(new goToMainMenu());
        //backSmallButton.addActionListener(new goToMainMenu());

    }
        
    //no changes in backSmallButton
    private void addClientGUI() {

        addClient.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;// column
        gbc.gridy = 0;// row
        gbc.insets = new Insets(20,20,20,20);
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
        addClient.add(backSmallButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        submit2.setOpaque(false);
        submit2.setContentAreaFilled(false);
        submit2.setBorderPainted(false);
        addClient.add(submit2, gbc);
    }

    //no changes in backSmallButton
    private void addEmpGUI(){

        addEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;// column
        gbc.gridy = 0;// row
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        addEmp.add(domainComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);
        addEmp.add(backSmallButton,gbc);
;
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        submit1.setOpaque(false);
        submit1.setContentAreaFilled(false);
        submit1.setBorderPainted(false);
        addEmp.add(submit1, gbc);
    }

    //no changes in backSmallButton
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
        gbc.ipadx = 100;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicDOB, gbc);
        dynamicDOB.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(Company, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicCompany, gbc);
        dynamicCompany.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(totalOrders, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remClient.add(dynamicTotalOrder, gbc);
        dynamicCompany.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 5;
        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);
        remClient.add(backSmallButton,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remove1.setOpaque(false);
        remove1.setContentAreaFilled(false);
        remove1.setBorderPainted(false);
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
        dynamicProjectsWorked.setText(Integer.toString(E.getProjectsWorked()) );
        dynamicProjectsLed.setText(Integer.toString(E.getProjectsLed()) );
    }

    private void updateProjectGUI(project P){
        
        int index = 0;
        String item = P.getProjectStatus();
        System.out.println("item: " + item);
        try{
            if(item == null)
                throw new noData();    
            for (int i = 0; i < statusChoices.length; i++) {
                if(item.compareToIgnoreCase(statusChoices[i])==0){
                    index = i;
                    break;
                }
            }
            client c = new client();
            c.setID(P.getClientID());
            c.ClientPriority();
            System.out.println(index);
            dynamicProjectNameTextField.setText(P.getProjectName());
            System.out.println(P.getClientID()); //--> Shows NULL here
            dynamicClientIDTextField.setText(P.getClientID());
            //System.out.println("UpdateRemEmpGUI: " + p.getName());
            dynamicStatusTextField.setText(P.getProjectStatus());
            dynamicDeadlineTextField.setText(P.getProjectDeadline());
            System.out.println("Client ID: " + c.getID() + "Priority: " + c.getPriority());
            
            if(c.getPriority() == 0)
                dynamicPriority.setText("No Projects Paid Yet");
            else
                dynamicPriority.setText(String.format("%d", c.getPriority()));
            
            statusComboBox.setSelectedIndex(index);
            String full_log = P.getProjectLog();
            String description = full_log.split("#")[0].replaceAll("\\\\n", System.getProperty("line.separator"));
            descriptionTextField.setText(description);
            projectUpdateStatus.repaint();
        }catch(noData nd){
            nd.displaYError(frame);
        }
    }

    //no changes in backSmallButton
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
        gbc.ipadx = 100;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(allID1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicName, gbc);
        dynamicName.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDOB, gbc);
        dynamicDOB.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(experience, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicExperience, gbc);
        dynamicExperience.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(domain, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicDomain, gbc);
        dynamicDomain.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 5;
        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);
        remEmp.add(backSmallButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remove2.setOpaque(false);
        remove2.setContentAreaFilled(false);
        remove2.setBorderPainted(false);
        remEmp.add(remove2,gbc);
        
        allID1.addActionListener(new handleShowEmpDetails());

    }
    
    //no changes in backSmallButton
    private void changeProjectStatus(){
        admin a = new admin();
        String[] projectList = a.ProjectList();
        projectUpdateStatus.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        allID3.removeAllItems();
        for (String id : projectList) {
            allID3.addItem(id);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID2.setForeground(Color.WHITE);
        allID2.setBackground(Color.DARK_GRAY);
        allID2.setBorder(new LineBorder(Color.DARK_GRAY));
        projectUpdateStatus.add(allID3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(projectName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(dynamicProjectNameTextField, gbc);
        dynamicProjectNameTextField.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(clientID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(dynamicClientIDTextField, gbc);
        dynamicClientIDTextField.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(status, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(statusComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(deadline, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectUpdateStatus.add(dynamicDeadlineTextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);
        projectUpdateStatus.add(backSmallButton,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        change1.setOpaque(false);
        change1.setContentAreaFilled(false);
        change1.setBorderPainted(false);
        projectUpdateStatus.add(change1,gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        viewChanges.setOpaque(false);
        viewChanges.setContentAreaFilled(false);
        viewChanges.setBorderPainted(false);
        projectUpdateStatus.add(viewChanges,gbc);

        allID3.addActionListener(new handleShowProjectDetails());
        change1.addActionListener(new handleStatusChange());
    }

    //no changes in backSmallButton
    private void approveProjectGUI() throws noData{
        admin a = new admin();
        String[] projectList = a.ProjectListNotApproved();
        if(projectList == null){
            System.out.println("Project List is NULL");
            throw new noData();
        }
        projectApprove.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        allID3.removeAllItems();
        for (String id : projectList) {
            allID3.addItem(id);
        }
        allID3.setSelectedIndex(0);
        System.out.println("Printing selected index of allID3:"+allID3.getSelectedIndex());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(clientID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectApprove.add(dynamicClientIDTextField, gbc);
        dynamicClientIDTextField.setEditable(false);

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
        descriptionLabel.setForeground(Color.WHITE);
        projectApprove.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descriptionTextField.setLineWrap(true);
        descriptionTextField.setEditable(false);
        descriptionTextField.setForeground(Color.WHITE);
        descriptionTextField.setCaretColor(Color.WHITE);
        descriptionTextField.setBackground(Color.DARK_GRAY);
        descriptionTextField.setBorder(new LineBorder(Color.DARK_GRAY));
        //viewProject.add(descriptionTextField, gbc);
        projectApprove.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        priorityLabel.setForeground(Color.WHITE);
        projectApprove.add(priorityLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        projectApprove.add(dynamicPriority,gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        projectApprove.add(backSmallButton,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Approve.setOpaque(false);
        Approve.setContentAreaFilled(false);
        Approve.setBorderPainted(false);
        projectApprove.add(Approve,gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reject.setOpaque(false);
        reject.setContentAreaFilled(false);
        reject.setBorderPainted(false);
        projectApprove.add(reject,gbc);

        allID3.addActionListener(new handleShowProjectDetails());
        Approve.addActionListener(new handleApproval());
        reject.addActionListener(new handleReject());
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
            frame.dispose();
            new admingui(); 
            //disposing and re-creating the frame fixed a lot of bugs in the back button part of the GUI such as the showProjectDetails 
        }
    }
    
    class goToChangeStatus implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("Update Project Status");
            changeProjectStatus();
            card.show(display,"projectStatusMenu");
            frame.repaint();
            frame.revalidate();
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

    //changes made here , card no longer goes to the mainMenu but stays in the same menu
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
                    card.show(display, "addEmployeeMenu");


                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    card.show(display, "addEmployeeMenu");
                }
            }

        }
    }

    //changes made here , card no longer goes to the mainMenu but stays in the same menu
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
                    card.show(display,"addClientMenu");
                    
                }else if(failure == 1){
                    System.out.println("Failed");
                    JOptionPane.showMessageDialog(frame, "Data Entry Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    //disposing the current frame and invoking the admingui to create a new frame which
                    //will technically redirect the admin to the home screen
                    card.show(display,"addClientMenu");
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

    class handleViewEmployee implements ActionListener{
        public void actionPerformed(ActionEvent a){
            heading.setText("View Employee");
            frame.dispose();
            new EmpReportGui();
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
            if(input == 0 && type.compareToIgnoreCase("employee") == 0){
                heading.setText("Employee Menu");
                card.show(display,"employeeMenu");
            }else if(input == 0 && type.compareToIgnoreCase("client") == 0){
                heading.setText("Client Menu");
                card.show(display,"cliMenu");
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

    class handleShowProjectDetails implements ActionListener{
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            project p = new project();
            System.out.println("In handleShowProjectDetails");
            p.setProjectID((String)allID3.getSelectedItem());
            System.out.println("Project ID: " + p.getProjectID());
            p = ad.showPrimaryDetails(p);
            updateProjectGUI(p);

            
        }
    }

    class handleApproveProjects implements ActionListener{
        public void actionPerformed(ActionEvent a){
            //admin ad = new admin();
            try{
                approveProjectGUI();
                card.show(display,"projectApproveMenu");
                //allID3.addItemListener(new handleShowProjectDetails());
                frame.repaint();
                frame.revalidate();
                
            }catch(noData nd){
                nd.displaYError(frame);
            }
        }
    }

    class handleViewProjects implements ActionListener{
        public void actionPerformed(ActionEvent a){
            try{
                new ProjectReportGui();
                frame.dispose();
            }catch(noData nd){
                nd.displaYError(frame);

            }
        }
    }
    
    class handleApproval implements ActionListener{
        public void actionPerformed(ActionEvent a){
            admin ad = new admin();
            project p = new project();
            p.setProjectID((String)allID3.getSelectedItem());
            p.autoAssignProjectType();
            try {
                p.setProjectMembers();
                int output = logPrompt(p);
                if(output==1){
                    p.assignProjectHead();   
                    p.updateEmpStatus(p.getProjectMembers(), "Y");
                    ad.approveProject(p);
                    JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
                }else if(output == 0){
                    JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to Update Status", "Info", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (noEmployeeAvailable nea) {
                System.out.println("Error in assigning employees to the project");
                nea.displayError(frame);
                int output = logPrompt(p);
                if(output==1){
                    JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
                }else if(output == 0){
                    JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to Update Status", "Info", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            
        }
    }

    class handleReject implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            project pro = new project();
            admin ad = new admin();
            pro.setProjectID((String)allID3.getSelectedItem());
            int output = logPrompt(pro);
            if(output == 1){
                ad.ProjectChanges(pro,"REJECTED");
                JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to update", "Info", JOptionPane.PLAIN_MESSAGE);

            }
            frame.repaint();
        }
    }

    class handleStatusChange implements ActionListener{
        public void actionPerformed(ActionEvent a){
            String status = (String)statusComboBox.getSelectedItem();
            System.out.println(status);
            admin ad = new admin();
            project p = new project();
            p.setProjectID((String)allID3.getSelectedItem());
            int output = logPrompt(p);
            if(output == 1 && status.compareToIgnoreCase("Complete")==0){
                System.out.println("Project Completed");
                p.updateEmpStatus(p.autoRetrieveProjectMembers(), "N");
                ad.updateProjectStatus(p, status);
                JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
            }else if(output == 1 && status.compareToIgnoreCase("Complete")!=0){
                System.out.println("Project Not Completed");
                ad.updateProjectStatus(p, status);
                JOptionPane.showMessageDialog(frame, "Status Updated", "Info", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(frame, "Status Not Updated: Provide Log to update", "Info", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }


}

    

class Driver {
    public static void main(String[] args) {
       new admingui();
       //adg.logPrompt();
    }
}