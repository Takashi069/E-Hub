package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import gui.secret;

public class project {

    private String ProjectID;
    private String ProjectName;
    private String ProjectType;
    private String ProjectDeadline;
    private String[] ProjectMembers;
    private String ProjectHead;
    private String ProjectStatus;
    private String ClientID;

    public String getProjectID() {
        return this.ProjectID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
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

    public void setProjectType(String ProjectType) {
        this.ProjectType = ProjectType;
    }

    public String getProjectDeadline() {
        return this.ProjectDeadline;
    }

    public void setProjectDeadline(String ProjectDeadline) {
        this.ProjectDeadline = ProjectDeadline;
    }

    public String[] getProjectMembers() {
        return this.ProjectMembers;
    }

    public void setProjectMembers(String[] ProjectMembers) {
        this.ProjectMembers = ProjectMembers;
    }

    public String getProjectHead() {
        return this.ProjectHead;
    }

    public void setProjectHead(){
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
            String sql = String.format(
                    "select Emp_ID from employee where Specialisation_ID = '%s' and Engaged_In_Project = 'N' order by Emp_Join_Date;","WEB001");
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String Emp_ID = rs.getString("Emp_ID");
                stmt = c.createStatement();
                String sql2 = String.format(
                "update Project set project_leader = '%s' where Project_ID = '%s';", Emp_ID,"PRO001");
                PreparedStatement ps = c.prepareStatement(sql2);
                int output = 0;
                output = ps.executeUpdate();
                System.out.println(output + " Row(s) Updated");
                String sql3 = String.format(
                "UPDATE employee set Engaged_In_Project = 'Y' where Emp_ID = '%s';",Emp_ID);
                ps = c.prepareStatement(sql3);
                output = ps.executeUpdate();
                System.out.println(output + " Row(s) Updated");
            }
                rs.close();
                stmt.close();
        }catch(Exception e)
    {
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

class Project_report extends project {

    private String Date_of_Commencement;

    public String getDate_of_Commencement() {
        return this.Date_of_Commencement;
    }

    public void setDate_of_Commencement(String Date_of_Commencement) {
        this.Date_of_Commencement = Date_of_Commencement;
    }

    public String displayReport() {
        return "{" +
                " ProjectID='" + getProjectID() + "'" +
                ", ProjectName='" + getProjectName() + "'" +
                ", ProjectType='" + getProjectType() + "'" +
                ", ProjectDeadline='" + getProjectDeadline() + "'" +
                ", ProjectMembers='" + getProjectMembers() + "'" +
                ", ProjectHead='" + getProjectHead() + "'" +
                ", ProjectStatus='" + getProjectStatus() + "'" +
                ", ClientID='" + getClientID() + "'" +
                " Date_of_Commencement='" + getDate_of_Commencement() + "'" +
                "}";
    }

}

class driver{
    public static void main(String[] args) {
        project obj = new project();
        obj.setProjectHead();
        
    }
}
