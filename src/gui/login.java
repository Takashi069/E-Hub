package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends JFrame implements ActionListener {
    //Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JPanel panel = new JPanel();

    login() {
        setLayoutManager();
        //setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        add(panel);
    }

    public void setLayoutManager() {
        panel.setLayout(new GridBagLayout());
    }

    /* public void setLocationAndSize() {
        userLabel.setBounds(330, 160, 193, 52);
        passwordLabel.setBounds(330, 280, 193, 52);
        userTextField.setBounds(450, 170, 281, 40);
        passwordField.setBounds(450, 286, 281, 40);
        showPassword.setBounds(520, 350, 162, 30);
        loginButton.setBounds(400, 420, 150, 30);
        resetButton.setBounds(580, 420, 150, 30);

    } */

    public void addComponentsToContainer() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 10;
        gbc.insets = new Insets(20,20,20,20);
        panel.add(userLabel,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(userTextField,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(showPassword,gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginButton,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(resetButton,gbc);
    }

    public void addActionEvent() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    secret obj = new secret();
                    c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass); // We have used objects here as
                                                                                      // the URL, username and psswd are
                                                                                      // different for
                } catch (Exception e) { // each one of us. So all our necessary info is stored in secret.java
                    e.printStackTrace();
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }
                try {
                    System.out.println("Opened database successfully");
                    stmt = c.createStatement();
                    String userText;
                    String pwdText;
                    userText = userTextField.getText();
                    pwdText = String.valueOf(passwordField.getPassword());
                    String sql = String.format(
                            "select Substring(ID,1,3) as id,id as full_id, Password from Login where username='%s';",
                            userText);
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        if (rs.getString("password").equals(pwdText)) { // This line verifies the password
                            if (rs.getString("id").equals("ADM")) {
                                // redirect to admin dashboard
                                System.out.println("Welcome admin");
                                new admingui();
                                dispose();
                            }
                            if (rs.getString("id").equals("EMP")) {
                                System.out.println("Welcome employee");
                                // redirect to employee dashboard
                            }
                            if (rs.getString("id").equals("CLI")) {
                                System.out.println("Welcome Client");
                                new clientgui(rs.getString("full_id"));
                                dispose(); // this will close the login frame completely
                            }
                        }
                        rs.close();
                        c.close();
                        stmt.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        });
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        passwordField.setEchoChar('*'); // replace whatever the user types with a character.
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0); // setting the character to 0 indicates that we want the password
                                                     // field to behave as a normal TextField
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }

    public static void main(String[] a) {
        login frame = new login();
        frame.setSize(new Dimension(960, 640));
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
