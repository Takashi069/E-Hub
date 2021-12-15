package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

import gui.secret;
import exceptions.*;

public class project {

    private String ProjectID;
    private String ProjectName;
    private String ProjectType;
    private String ProjectDeadline;
    private String[] ProjectMembers = new String[5];
    private String ProjectHead;
    private String ProjectStatus;
    private String ProjectLog;
    private String ClientID;

    public String getProjectID() {
        return this.ProjectID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public String getProjectLog() {
        return this.ProjectLog;
    }

    public void setProjectLog(String ProjectLog) {
        this.ProjectLog = ProjectLog;
    }

    public String getProjectName() {
        return this.ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getProjectType() {
        return this.ProjectType;
    }

    public void setProjectType(String domain){
        this.ProjectType = domain;
    }

    public void autoAssignProjectType() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            secret obj = new secret();
            c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        try {
            System.out.println("Opened database successfully for assigning Project Head");
            stmt = c.createStatement();
            String sql = String.format(
                    "select domain from project where project_id = '%s';",
                    this.ProjectID);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.ProjectType = rs.getString(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error in Auto Assigning Project Type");
            System.out.println(e.toString());
        }
    }

    public String getProjectDeadline() {
        return this.ProjectDeadline;
    }

    public void setProjectDeadline(String ProjectDeadline) {
        this.ProjectDeadline = ProjectDeadline;
    }

    public String[] autoRetrieveProjectMembers(){
        secret s = new secret();
        String query1 = "select emp_id from project_team where project_id = ?";
        String query2 = "select project_leader from project_team where project_id = ?";
        String[] allProjMembers = new String[5];

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.prepareStatement(query1);
            ps.setString(1, this.ProjectID);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                allProjMembers[i] = rs.getString(1);
                i++;
            }

            ps = c.prepareStatement(query2);
            ps.setString(1, this.ProjectID);
            rs = ps.executeQuery();
            while(rs.next()){
                allProjMembers[i] = rs.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return allProjMembers;
    }

    public String[] getProjectMembers() {
        return this.ProjectMembers;
    }

    public String retrieveLog(String id) {
        Connection c = null;
        Statement stmt = null;
        String retrieved_log = "";
        try {
            Class.forName("org.postgresql.Driver");
            secret obj = new secret();
            c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        try {
            stmt = c.createStatement();
            String sql = String.format(
                    "select project_log from project where project_id='%s'", id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                retrieved_log = rs.getString(1);
            }
            return retrieved_log;
        } catch (Exception e) {
            System.out.println(e.toString());
            return "No logs registered";
        }
    }

    public void setProjectMembers() throws noEmployeeAvailable{//sets the members for a project, the members are stored in Project P
        Connection c = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        try {
            Class.forName("org.postgresql.Driver");
            secret obj = new secret();
            c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        String query1 = "select count(Emp_ID) from employee where Specialisation_ID = ? and Engaged_In_Project = 'N'";
        
        try {
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ps = c.prepareStatement(query1);
            ps.setString(1, ProjectType);
            ResultSet rs = ps.executeQuery();
            String[] tmp_list=new String[4];
            int size = 0;
            while(rs.next()){
                if(rs.getInt(1) < 5){ //the reason why it's less than 5 is without a project leader, there wouldnt be a proper project
                    System.out.println("Employee Less than 5");
                    throw new noEmployeeAvailable();
                }else{
                    size = rs.getInt(1);
                    System.out.println("Size: " + size);
                }
            }
            String sql = String.format(
                    "select Emp_ID from employee where Specialisation_ID = '%s' and Engaged_In_Project = 'N' order by experience asc;", ProjectType);
            rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next() && i < 4) { // the reason why i<4 is because we're picking 4 employees to work on this
                                         // project
                String Emp_ID = rs.getString("Emp_ID");
                tmp_list[i] = Emp_ID;
                i++;
            }
            rs.close();
            stmt.close();
            for (String s : tmp_list) {
                System.out.print(s + " ");
            }
            //this.ProjectMembers = tmp_list.clone(); //copy all contents of tmp_list to ProjectMembers
            for (int j = 0; j < tmp_list.length; j++) {
                this.ProjectMembers[j] = tmp_list[j];
            }

            String query3 = "insert into project_team(project_id,emp_id) values(?,?)";
            try{
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                ps = c.prepareStatement(query3);
                int k = 0;
                int output = 0;
                while(k<4){
                    ps.setString(1, this.ProjectID);
                    ps.setString(2, this.ProjectMembers[k]);
                    output = ps.executeUpdate();
                    System.out.println(output + " Rows Inserted");
                    k++;
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Error in Assigning Employee to Project Team");
            }
        } catch (noEmployeeAvailable n) {
            throw new noEmployeeAvailable(); // throwing it again so it get's caught in the admingui
        }catch(Exception e){
            System.out.println("Error in assigning employee to project team ");
            //e.printStackTrace();
        }

       

    }

    public void updateEmpStatus(String[] Emp_IDs,String type) {//type can be Y/N
        Connection c = null;
        Statement stmt = null;
        for (String string : Emp_IDs) {
            System.out.print(string + " ");
        }
        System.out.println("\n");
        try {
            Class.forName("org.postgresql.Driver");
            secret obj = new secret();
            c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Size of EMP-ID: " + Emp_IDs.length);
        int i = 0;
        while (i < 5) { // this while loop is used to change the status of the employees once the
                        // project is completed
            try {
                System.out.println("Opened database successfully for changing status of employee");
                stmt = c.createStatement();
                String sql = String.format(
                        "update employee set Engaged_In_Project = '"+type+"' where Emp_ID = '%s';", Emp_IDs[i]);
                i++;
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
    }

    public String getProjectHead() {
        return this.ProjectHead;
    }

    public void setProjectHead(String headid){
        this.ProjectHead = headid;
    }

    public void assignProjectHead() {//sets the project head
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            secret obj = new secret();
            c = DriverManager.getConnection(obj.url, obj.dbUser, obj.dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            System.out.println("Opened database successfully for assigning Project Head");
            stmt = c.createStatement();
            String sql = String.format(
                    "select Emp_ID from employee where Specialisation_ID = '%s' and Engaged_In_Project = 'N' order by experience desc;",
                    this.getProjectType());
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String Emp_ID = rs.getString("Emp_ID");

                this.setProjectHead(Emp_ID); // --> Assign the project Head to the Project Head variable
                stmt = c.createStatement();
                this.ProjectMembers[4] = Emp_ID;
                String sql2 = String.format(
                        "update Project set project_leader = '%s' where Project_ID = '%s';", Emp_ID, ProjectID);
               
                PreparedStatement ps = c.prepareStatement(sql2);
                int output = 0;
                output = ps.executeUpdate();
                System.out.println(output + " Row(s) Updated");

                String sql3 = String.format(
                    "update project_team set project_leader = '%s' where project_ID = '%s';", Emp_ID, ProjectID);
                ps = c.prepareStatement(sql3);
                output = 0;
                output = ps.executeUpdate();
                System.out.println(output + " Row(s) Updated");
                
                String sql4 = String.format(
                        "UPDATE employee set Engaged_In_Project = 'Y' where Emp_ID = '%s';", Emp_ID);
                ps = c.prepareStatement(sql4);
                output = ps.executeUpdate();
                System.out.println(output + " Row(s) Updated");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error in Assigning Head");
            System.out.println(e.toString());
        }
    }

    public String getProjectStatus() {
        return this.ProjectStatus;
    }

    public void setProjectStatus(String ProjectStatus) {
        this.ProjectStatus = ProjectStatus;
    }

    public String getClientID() {
        return this.ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

}

class driver {
    public static void main(String[] args) {
        project obj = new project();
        obj.setProjectID("PRO002");
        obj.setProjectType("WEB");
        try{
            obj.setProjectMembers();
            obj.assignProjectHead();
            obj.updateEmpStatus(obj.getProjectMembers(), "Y");
            obj.updateEmpStatus(obj.getProjectMembers(),"N");
            
            System.out.println("The Project Head is: " + obj.getProjectHead());
        /* }catch(noEmployeeAvailable neA){
            neA.displayError(new JFrame()); */
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
