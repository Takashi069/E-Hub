package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import admin.admin;
import assets.getAssets;
import employee.employee;
import report.employeeReport;


public class EmpReportGui {
    JFrame frame = new JFrame();
    JPanel display = new JPanel();
    getAssets path = new getAssets();
    JLabel remEmp = new JLabel(new ImageIcon(path.frame_bg));
    String[] emptyArray = { "null" };
    JComboBox<String> allID1 = new JComboBox<String>(emptyArray);
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name: ");
    JTextField dynamicName = new JTextField();
    JLabel dob = new JLabel("DOB ( Format: YYYY-MM-DD )");
    JTextField dynamicDOB = new JTextField();
    JLabel experience = new JLabel("Experience (In Years)");
    JTextField dynamicExperience = new JTextField();
    JLabel domain = new JLabel("Specialisation Domain");
    JTextField dynamicDomain = new JTextField();
    JLabel projectsWorked = new JLabel("Total Projects Worked");
    JLabel projectsLed = new JLabel("Total Projects Led");
    JTextField dynamicProjectsWorked = new JTextField();
    JTextField dynamicProjectsLed = new JTextField();
    JButton backSmallButton = new JButton(new ImageIcon(path.back_btn));
    CardLayout card;

    public EmpReportGui() {
        card = new CardLayout();
        display.setLayout(card);
        frame.setSize(1280, 1024);
        display.add(remEmp, "removeClientMenu");
        frame.add(display);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin ad = new admin();
        employee emp = new employee();
        remEmp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] ID = ad.PersonList(emp);
        allID1.setBackground(Color.WHITE);
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
        id.setForeground(Color.WHITE);
        remEmp.add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        allID1.setForeground(Color.WHITE);
        allID1.setBackground(Color.DARK_GRAY);
        allID1.setBorder(new LineBorder(Color.DARK_GRAY));
        remEmp.add(allID1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        name.setForeground(Color.white);
        remEmp.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        remEmp.add(dynamicName, gbc);
        dynamicName.setForeground(Color.WHITE);
        dynamicName.setBackground(Color.DARK_GRAY);
        dynamicName.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicName.setCaretColor(Color.WHITE);
        dynamicName.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dob.setForeground(Color.white);
        remEmp.add(dob, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dynamicDOB.setForeground(Color.WHITE);
        dynamicDOB.setBackground(Color.DARK_GRAY);
        dynamicDOB.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicDOB.setCaretColor(Color.WHITE);
        remEmp.add(dynamicDOB, gbc);
        dynamicDOB.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        experience.setForeground(Color.white);
        remEmp.add(experience, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dynamicExperience.setForeground(Color.WHITE);
        dynamicExperience.setBackground(Color.DARK_GRAY);
        dynamicExperience.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicExperience.setCaretColor(Color.WHITE);
        remEmp.add(dynamicExperience, gbc);
        dynamicExperience.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        domain.setForeground(Color.white);
        remEmp.add(domain, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dynamicDomain.setForeground(Color.WHITE);
        dynamicDomain.setBackground(Color.DARK_GRAY);
        dynamicDomain.setBorder(new LineBorder(Color.DARK_GRAY));
        dynamicDomain.setCaretColor(Color.WHITE);
        remEmp.add(dynamicDomain, gbc);
        dynamicDomain.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectsWorked.setForeground(Color.white);
        remEmp.add(projectsWorked, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
       dynamicProjectsWorked.setForeground(Color.WHITE);
       dynamicProjectsWorked.setBackground(Color.DARK_GRAY);
       dynamicProjectsWorked.setBorder(new LineBorder(Color.DARK_GRAY));
       dynamicProjectsWorked.setCaretColor(Color.WHITE);
        remEmp.add(dynamicProjectsWorked, gbc);
        dynamicProjectsWorked.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectsLed.setForeground(Color.white);
        remEmp.add(projectsLed, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
         dynamicProjectsLed.setForeground(Color.WHITE);
       dynamicProjectsLed.setBackground(Color.DARK_GRAY);
       dynamicProjectsLed.setBorder(new LineBorder(Color.DARK_GRAY));
       dynamicProjectsLed.setCaretColor(Color.WHITE);
        remEmp.add(dynamicProjectsLed, gbc);
        dynamicProjectsLed.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 7;
        backSmallButton.setOpaque(false);
        backSmallButton.setContentAreaFilled(false);
        backSmallButton.setBorderPainted(false);
        remEmp.add(backSmallButton, gbc);
        allID1.addActionListener(new handleShowEmpDetails());
        frame.setVisible(true);
backSmallButton.addActionListener(new goToMainMenu());
    }

    private void updateEmployeGui(employee E) {
        dynamicName.setText(E.getName());
        dynamicDOB.setText(E.getDOB());
        //System.out.println("UpdateRemEmpGUI: " + E.getName());
        dynamicExperience.setText(String.format("%d", E.getExperience()));
        dynamicDomain.setText(E.getDomain());
        dynamicProjectsWorked.setText(Integer.toString(E.getProjectsWorked()));
        dynamicProjectsLed.setText(Integer.toString(E.getProjectsLed()));
    }

    class handleShowEmpDetails implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            employeeReport empRep = new employeeReport();
            employee emp = new employee();
            emp.setID((String) allID1.getSelectedItem());
            emp = empRep.displayReport(emp);
            //System.out.println("\nEmployee GUI Details called\n");
            updateEmployeGui(emp);
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
class newDriverclassEMP {
        public static void main(String[] args) {
            new EmpReportGui();
            //adg.logPrompt();
        }
    }
