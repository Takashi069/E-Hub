package report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Project.project;
import gui.secret;
public class projectReport {
    
    public project displayReport(project p) {
        secret s = new secret();
        Connection c = null;
        project retrieveProject = new project();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Date date;
        String query1 = "select project_id,project_name,date_of_release,status_of_software,client_id,project_log from project where project_id = ?";
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.prepareStatement(query1);
            ps.setString(1, p.getProjectID());
            rs = ps.executeQuery();
            while(rs.next()){
                retrieveProject.setProjectID(rs.getString(1));
                retrieveProject.setProjectName(rs.getString(2));
                date  = rs.getDate(3);
                retrieveProject.setProjectDeadline(date.toString());
                retrieveProject.setProjectStatus(rs.getString(4));
                retrieveProject.setClientID(rs.getString(5));
                retrieveProject.setProjectLog(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return retrieveProject;
    }

    
    
}