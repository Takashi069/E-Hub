package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date; //To retrieve the Current Date

import person.Person;
import client.client;
import employee.employee;
import gui.secret;

public class admin extends Person {
    secret s = new secret();
    private String adminID;
    private String password;

    admin(){
        super();
        adminID = "ADM000";
        password = "admin";
    }

    
    public String getID() {
        return adminID;
    }

    public void setID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void AddPerson(employee E){
        Connection c = null;
        Statement stmt = null;
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        System.out.println(sqldate);

        //We need to add the data in the Person table first
        String personQuery = "insert into person values" + "(" +
                              "'EMP001'" + "," +  
                              "'Akash', 'Harikumar'" + "," +
                              "'Mynagapally', 'Edavanassery', 'Kollam', 'Kerala'" + "," +
                              "'690519'" + "," +
                              "'Indian'" + "," + 
                              "'07/08/2001'" + ")";
        
        String Empquery = "insert into employee values" + 
        "('EMP001', 'University Degree', 'WEB', 'N',? )";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();

            //To set the date as the current date
            PreparedStatement ps = c.prepareStatement(Empquery);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            
            int output = stmt.executeUpdate(personQuery);
            System.out.println(output + " Rows Updated");
            output = ps.executeUpdate();
            System.out.println(output + " Rows Updated");
            stmt.close();
            c.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void AddPerson(client C){
        Connection c = null;
        Statement stmt = null;
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        System.out.println(sqldate);

        //We need to add the data in the Person table first
        String personQuery = "insert into person values" + "(" +
                              "'CLI001'" + "," +  
                              "'Akshaj', 'Harikumar'" + "," +
                              "'Mynagapally', 'Edavanassery', 'Kollam', 'Kerala'" + "," +
                              "'690519'" + "," +
                              "'Indian'" + "," + 
                              "'12/12/1987'" + ")";
        
        String Cliquery = "insert into client values" + 
        "('CLI001', 'Amazon', 0)";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();

            //To set the date as the current date
            PreparedStatement ps = c.prepareStatement(Cliquery);
            //ps.setDate(1, new java.sql.Date(date.getTime()));
            
            int output = stmt.executeUpdate(personQuery);
            System.out.println(output + " Row(s) Updated");
            output = ps.executeUpdate();
            System.out.println(output + " Row(s) Updated");
            stmt.close();
            c.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void removePerson(client C){
        Connection c = null;
        String query = "delete from person where id = ?";
        //The following lines of code are temporary:
        C.setID("CLI001");
        String client_id = C.getID();

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            int output = ps.executeUpdate();
            System.out.println(output + " Row(s) Removed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void removePerson(employee E){
        Connection c = null;
        String query = "delete from person where id = ?";
        //The following line of code is temporary:
        E.setID("EMP001");
        String emp_id = E.getID();

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, emp_id);
            int output = ps.executeUpdate();
            System.out.println(output + " Row(s) Removed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
}

//For Testing 
class Driver{
    public static void main(String[] args) {
        admin a = new admin();
        employee E = new employee();
        client Cli = new client();
        a.AddPerson(E);
        a.AddPerson(Cli);
        a.removePerson(Cli);
        a.removePerson(E);
    }
}