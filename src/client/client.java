package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import person.Person;
import gui.secret;
import Project.project;

public class client extends Person {
    secret s = new secret();
    public client(){
        super();
    }
    private String clientID;
    private String password;
    private int totalProjectsRequested;
    private int priority;

    public String getID() {
        return this.clientID;
    }

    public void setID(String clientID) {
        this.clientID = clientID;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalProjectsRequested() {
        return this.totalProjectsRequested;
    }

    public void setTotalProjectsRequested(int totalProjectsRequested) {
        this.totalProjectsRequested = totalProjectsRequested;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void AddProject(project P) {
        Connection c = null;
        Statement stmt = null;

        //We need to add the data in the Project table first
        String ProjectQuery = "insert into Project values" + "(" +
                "'PRO001'" + "," +
                "'CLI001'" + "," +
                "'Doofinshmertz evil'" + "," +
                "'12/12/2021'"  + "," +
                "'12/12/2022'" + "," +
                "'NOT APPROVED'" + "," +
                "'WEB'" + "," +
                "'EMP001'" + ")";


        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();

            //To set the date as the current date
            PreparedStatement ps = c.prepareStatement(ProjectQuery);
            //ps.setDate(1, new java.sql.Date(date.getTime()));

            int output=0;

            output = ps.executeUpdate();
            System.out.println(output + " Row(s) Updated");
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeProject(project P){
        Connection c = null;
        String query = "delete from Project where Project_ID = ?";
        //The following lines of code are temporary:
       
        String client_id = "PRO001";

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
}

class Client_Report extends client {
    private int totalProjectsCompleted;
    private int totalProjectsPaid;

    public int getTotalProjectsCompleted() {
        return this.totalProjectsCompleted;
    }

    public void setTotalProjectsCompleted(int totalProjectsCompleted) {
        this.totalProjectsCompleted = totalProjectsCompleted;
    }

    public int getTotalProjectsPaid() {
        return this.totalProjectsPaid;
    }

    public void setTotalProjectsPaid(int totalProjectsPaid) {
        this.totalProjectsPaid = totalProjectsPaid;
    }

    public String displayReport() {
        return "{" +
        " clientID='" + getID() + "'" +
            ", totalProjectsRequested='" + getTotalProjectsRequested() + "'" +
            ", priority='" + getPriority() + "'" +
            " totalProjectsCompleted='" + getTotalProjectsCompleted() + "'" +
            ", totalProjectsPaid='" + getTotalProjectsPaid() + "'" +
            "}";
    }

}
class Driver{
    public static void main(String[] args) {
        client Cli = new client();
        project pro = new project();
        //Cli.AddProject(pro);
        Cli.removeProject(pro);
    
 
    }
}