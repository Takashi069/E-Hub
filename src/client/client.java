package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import person.Person;
import gui.secret;
import Project.project;
import java.util.Vector;

public class client extends Person {
    secret s = new secret();

    public client() {
        super();
    }

    private String clientID;
    private String password;
    private int totalProjectsRequested;
    private int priority;
    private int Total_Orders;

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

    public int getTotal_Orders() {
        return this.Total_Orders;
    }

    public void setTotal_Orders(int Total_Orders) {
        this.Total_Orders = 0;
    }

    public void AddProject(project p) {
        Connection c = null;
        Statement stmt = null;

        // We need to add the data in the Project table first

        String count = "select count(Project_ID) as id from Project;";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(count);
            String newId = "";
            if (rs.next()) {
                int num = Integer.parseInt(rs.getString("id"));
                newId = String.format("PRO%03d", num + 1);
            }
            p.setProjectID(newId);

            String ProjectQuery = String.format(
                    "insert into Project(Project_ID, Client_ID, Project_Name, Date_of_Release, Status_of_software, Domain) values('%s','%s', '%s','%s','%s','%s')",
                    p.getProjectID(), p.getClientID(), p.getProjectName(), p.getProjectDeadline(), "NOT APPROVED",
                    p.getProjectType());

            stmt = c.createStatement();

            // To set the date as the current date
            PreparedStatement ps = c.prepareStatement(ProjectQuery);
            // ps.setDate(1, new java.sql.Date(date.getTime()));

            int output = 0;
            output = ps.executeUpdate();
            System.out.println(output + " Row(s) Updated");
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Total_Orders += 1;
    }

    public void removeProject(project P) {
        Connection c = null;
        String query = "delete from Project where Project_ID = ?";
        // The following lines of code are temporary:

        String client_id = "PRO001";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            int output = ps.executeUpdate();
            System.out.println(output + " Row(s) Removed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // something under work
    /*
     * public void ClientPriority(){
     * Connection c = null;
     * String query = "select Total_Orders from client;";
     * //The following lines of code are temporary:
     * 
     * // String client_id = "CLI001";
     * 
     * try{
     * Class.forName("org.postgresql.Driver");
     * c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
     * PreparedStatement ps = c.prepareStatement(query);
     * // ps.setString(1, client_id);
     * // ps.executeUpdate();
     * ResultSet rs = ps.executeQuery(query);
     * while (rs.next())
     * {
     * int x = rs.getInt("Total_Orders");
     * System.out.println(x + " is the count");
     * }
     * 
     * }catch(Exception e){
     * e.printStackTrace();
     * }
     * }
     */
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

    public void TotalProjectsCompleted() {
        Connection c = null;
        String query = "select count(Project_ID) as Totalprojcount from Project where Client_ID = ? and Status_of_Software='COMPLETED'";
        // The following lines of code are temporary:

        String client_id = "CLI001";
        try {
            int x = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                x = rs.getInt("Totalprojcount");
            }
            rs.close();
            System.out.println(x + " is the count");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TotalProjectsPaid() {
        Connection c = null;
        String query = "select count(Project_ID) as Totalprojcount from Project where Client_ID = ? and Status_of_Software='PAID'";
        // The following lines of code are temporary:

        String client_id = "CLI001";
        try {
            int x = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                x = rs.getInt("Totalprojcount");
            }
            rs.close();
            System.out.println(x + " is the count");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ClientPriority() {
        Connection c = null;
        String query = "select client_id,count(Project_ID) as Totalprojcount from Project where Status_of_Software='PAID' group by client_id order by Totalprojcount ";
        // The following lines of code are temporary:
        Statement ps = null;
        // String client_id = "CLI001";
        Vector<String> Clientvec = new Vector<String>();
        Vector<Integer> Tprojvec = new Vector<Integer>();
        Vector<Integer> Prionum = new Vector<Integer>();
        try {
            String x = "asd";
            int y = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.createStatement();

            // ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                x = rs.getString("client_id");
                y = rs.getInt("Totalprojcount");
                // for (int i = 0; i < Clientvec.size(); i++) {
                Clientvec.add(x);
                Tprojvec.add(y);
                // }

                // System.out.println(x);

                // System.out.println(y);
            }
            System.out.print(Clientvec);
            System.out.print(Tprojvec);
            // For prioirity thingy
            // update project set priority=? where ID=
            // (1,i)

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Driver {
    public static void main(String[] args) {
        client Cli = new client();
        project pro = new project();
        Client_Report clire = new Client_Report();
        clire.ClientPriority();
        // Cli.AddProject(pro);
        // Cli.removeProject(pro);
        // Cli.ClientPriority();
        // clire.TotalProjectsCompleted();
        // clire.TotalProjectsPaid();

        // Cli.AddProject(pro);
        Cli.removeProject(pro);

    }
}