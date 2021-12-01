package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public admin(){
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

    private String assignID(String type){
        int count = 0;
        String countString;
        type = type.toUpperCase();
        String query = "select count(distinct(emp_id)) as total_employees from employee";
        Statement stmt = null;
        Connection c = null;
        ResultSet rs = null;
        try{
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt("total_employees");
        }catch(Exception e){
            e.printStackTrace();
        }
        count++;
        countString = String.format("%d", count);
        if(countString.length()<3){
            for (int i = countString.length(); i < 3; i++){
                countString = "0"+countString;
            }
        }
        String finalID = "";
        //compareToIgnoreCase() -> 0 = same string, 1 = different strings
        if(type.compareToIgnoreCase("Client") == 0){
            finalID = "CLI" + countString;
        }else if(type.compareToIgnoreCase("Employee") == 0){
            finalID = "EMP" + countString;
        }else if(type.compareToIgnoreCase("Project") == 0){
            finalID = "PRO" + countString;
        }
        return finalID;
    }

    public int AddPerson(employee E){
        Connection c = null;
        Statement stmt = null;
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        System.out.println(sqldate);

        //We need to add the data in the Person table first
        String personQuery = "insert into person values (?,?,?,?,?,?,?,?,?)";
        
        String Empquery = "insert into employee values" + 
        "( ?, ?, ?, 'N',? )";
        
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();

            //Add the information in the Person table
            PreparedStatement ps = c.prepareStatement(personQuery);
            ps.setString(1, assignID("Employee"));;
            ps.setString(2, E.getName());
            ps.setString(3, E.getAddress()[0]);
            ps.setString(4, E.getAddress()[1]);
            ps.setString(5, E.getAddress()[2]);
            ps.setString(6, E.getAddress()[3]);
            ps.setString(7, String.format("%d", E.getPINCODE()));
            ps.setString(8, E.getNationality());
            ps.setDate(9, java.sql.Date.valueOf(E.getDOB()));
            
            int output = ps.executeUpdate();
            System.out.println(output + " Rows Updated");
            
            //Add the Employee information in the Employee Table
            ps = c.prepareStatement(Empquery);
            ps.setString(1, assignID("Employee"));
            ps.setInt(2,E.getExperience());
            ps.setString(3,E.getDomain());
            //To set the date as the current date
            ps.setDate(4, new java.sql.Date(date.getTime()));
            output = ps.executeUpdate();
            System.out.println(output + " Rows Updated");
            stmt.close();
            c.close();
            return 0;

        }catch(Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    public int AddPerson(client C){
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
            return 0;

        }catch(Exception e){
            e.printStackTrace();
            return 1;
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
       
        //  a.assignID("Employee");
    } 
}