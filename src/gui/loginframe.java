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

public class loginframe extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    loginframe() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(330, 160, 193, 52);
        passwordLabel.setBounds(330, 280, 193, 52);
        userTextField.setBounds(450, 170, 281, 40);
        passwordField.setBounds(450, 286, 281, 40);
        showPassword.setBounds(520, 350, 162, 30);
        loginButton.setBounds(400, 420, 150, 30);
        resetButton.setBounds(580, 420, 150, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                Connection c = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    secret obj = new secret();
                    c = DriverManager.getConnection(obj.url,obj.dbUser, obj.dbPass);
                } catch (Exception e) {
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
                    pwdText = passwordField.getText();
                    String sql = String.format(
                            "select Substring(ID,1,3) as id,id as full_id, Password from Login where username='%s';",
                            userText);
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        if (rs.getString("password").equals(pwdText)) {
                            if (rs.getString("id").equals("ADM")) {
                                // redirect to admin dashboard
                                System.out.println("Welcome admin");
                            }
                            if (rs.getString("id").equals("EMP")) {
                                System.out.println("Welcome employee");
                                // redirect to employee dashboard
                            }
                            if (rs.getString("id").equals("CLE")) {
                                System.out.println("Welcome Client");
                                clientgui cli = new clientgui(rs.getString("full_id"));
                                dispose();
                                cli.setVisible(true);
                            }
                        }
                        rs.close();
                        stmt.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        });
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }

    public static void main(String[] a) {
        loginframe frame = new loginframe();
        frame.setSize(new Dimension(1280, 1024));
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
